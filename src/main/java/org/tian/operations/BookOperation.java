package org.tian.operations;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.tian.mappers.BookMapper;
import org.tian.mappers.UserMapper;
import org.tian.pojo.Book;
import org.tian.pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 这个类用来标明关于book对象的操作，主要操作/函数包含以下几种：
 * 1、查找全部book
 * 2、按照id搜索book
 * 3、修改book信息
 * 4、添加book
 * 5、删除book
 * ------------------------
 * 不采用注解式开发。
 * ------------------------
 * 本类中使用的函数已经在TestBookPOperations类中测试，如有问题，请到对应类中重新进行单元测试。
 */
public class BookOperation {
    /**
     * 选择全部book数据。
     * @throws IOException 抛出一个io异常。
     */
    public List<Book> selectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        List<Book> books;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            books = mapper.selectAllBooks();
        }

        for (Book book :
                books) {
            System.out.println(book);
        }

        return books;
    }

    /**
     * 通过id选择book。
     * @param bookId bookId
     * @throws IOException 抛出io异常。
     */
    public Book selectOne(int bookId) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Book book1 = null;

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            book1 = mapper.selectOne(bookId);
            System.out.println(book1);
        }

        return book1;
    }
    /**
     * 添加新的book到书架。
     * 注意：如果希望自动添加id，请不要在传入的book对象构造的时候写入id属性。
     * @param book 封装了new book信息的book对象。
     * @throws IOException 抛出异常。
     */
    public void addBook(Book book) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            mapper.addBook(book);
            System.out.println("添加成功。"+book.getBookId()); // 返回主键
            session.commit();
        }

        System.out.println("下面是新的全部book信息：");

        // 调用了selectAll函数。
        selectAll();
    }

    /**
     * 编辑book信息。
     * 注意：请在传入的book中声明bookId，以便于检索要求改的book，否则本函数将会失效。
     * @param book 封装了新信息的book对象。
     * @throws IOException 抛出异常。
     */
    public void EditBook (Book book) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper mapper = session.getMapper(BookMapper.class);
            mapper.editBook(book);
            session.commit();
            System.out.println("编辑成功。");
        }

        System.out.println("下面是新的全部book信息，请注意对应id的book信息是否修改完成。");

        selectAll();
    }

    /**
     * 为book绑定一个user。
     * @param book 等待绑定的book
     * @param user 等待绑定的user。
     * @throws IOException 抛出异常。
     */
    // TODO:【为book绑定user的函数】代码有待完善，比如user是否已经存在，或者是否必须添加新的user，等情况，都还没有解决。
    public void boundUser(Book book, User user) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.addUser(user);
            int userid = user.getUserId();
            System.out.println("新添加的user是：" + userid); // 输出一下刚刚添加的userID。
            book.setUserId(userid);
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            bookMapper.addBook(book);
            session.commit();
            System.out.println("新添加的book是："+book.getBookId());
        }

        System.out.println("下面是新的全部book信息，请注意对应id的book信息是否修改完成。");

        selectAll();
    }
}
