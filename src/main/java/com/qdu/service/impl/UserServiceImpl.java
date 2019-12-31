package com.qdu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bean.Page;
import com.qdu.bean.User;
import com.qdu.mapper.UserMapper;
import com.qdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> queryList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapper.queryList();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        Page<User> result = new Page<>(pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                userList,
                pageInfo.getTotal(),
                pageInfo.getPages(),
                pageInfo.getPrePage(),
                pageInfo.getNextPage(),
                pageInfo.isIsFirstPage(),
                pageInfo.isIsLastPage());
        return result;
    }

    @Override
    public User queryUser(String username, String password) {
        return userMapper.queryUser(username,password);
    }

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
