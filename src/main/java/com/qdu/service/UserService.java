package com.qdu.service;

import com.qdu.bean.Page;
import com.qdu.bean.User;

public interface UserService {
    Page<User> queryList(int pageNum, int pageSize);

    User queryUser(String username, String password);

    User queryUserByName(String username);

    int addUser(User user);

    int deleteUserById(int id);

    void updateUser(User user);
}
