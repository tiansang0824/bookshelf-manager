package org.tian.mappers;

import org.tian.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAllUsers();

     User selectOneById(int userId);

     void addUser(User user);

     void editUserInfo(User user);

     void delUser(int userId);


}
