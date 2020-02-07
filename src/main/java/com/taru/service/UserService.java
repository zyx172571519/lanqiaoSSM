package com.taru.service;

import com.taru.model.User;

import java.util.List;

public interface UserService {

    //根据用户id删除用户
    public int deleteUserById(String userId);
    //查询用户详细信息
    public User queryUserById(String userId);
    //查询所有用户
    public List<User> queryAlluer();
    //多条件查询
    public List<User> queryAlltiaojian(String userId, String userName, String userTelephone);
    //批量删除用户
    public int deleteUser(String [] ids);
    //登录
    public User login(String userName, String userPassword);

    //注册
    public int insertUser(User user);

    //更改用户名
    public int updateUser(String userId,String userName);

    //模糊搜索
    public List<User> queryUserLike(String userName);

}
