package org.tian;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.tian.mappers.UserMapper;
import org.tian.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestUserOperations {

    /*
     * 本类用于测试对于books表的基本增删改查操作。
     * */
    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        List<User> users;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            users = mapper.selectAllUsers();
        }

        for (User user :
                users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectOne() throws IOException {
        int userId = 1;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectOneById(userId);
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser() throws IOException {
        User user = new User("用户名");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.addUser(user);
            System.out.println("添加成功。"+user.getUserId()); // 返回主键
            session.commit();
        }

        System.out.println("下面是新的全部book信息：");

        testSelectAll();
    }

    @Test
    public void testEditUser () throws IOException {
        User user = new User(3, "QAQ");

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.editUserInfo(user);
            session.commit();
            System.out.println("编辑成功。");
        }

        System.out.println("下面是新的全部book信息，请注意对应id的book信息是否修改完成。");

        testSelectAll();
    }

    @Test
    public void testDelUser() throws IOException {
        int userId = 3;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.delUser(userId);
            session.commit();
            System.out.println("删除成功。");
        }

        System.out.println("下面是新的全部book信息，请注意对应id的book信息是否修改完成。");

        testSelectAll();
    }
}
