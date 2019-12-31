package com.qdu.mapper;

import com.qdu.bean.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserMapper {
    List<User> queryList();

    User queryUser(@Param("username") String username, @Param("password") String password);

    User queryUserByName(@Param("username") String username);

    int addUser(User user);

    int deleteUserById(int id);

    void updateUser(User user);
}
