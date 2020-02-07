package com.taru.service.impl;

import com.taru.dao.UserDao;
import com.taru.model.User;
import com.taru.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public int deleteUserById(String userId) {
        return userDao.deleteUserById(userId);
    }
    /**
     * 根据用户id查询用户详情
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public User queryUserById(String userId) {
        return userDao.queryUserById(userId);
    }
    /**
     * 查询所有用户
     * @return
     */
    @Override
    @Transactional
    public List<User> queryAlluer() {
        return userDao.queryAlluer();
    }
    /**
     * 多条件查询
     * @param userId
     * @param userName
     * @param userTelephone
     * @return
     */
    @Override
    @Transactional
    public List<User> queryAlltiaojian(String userId, String userName, String userTelephone){
        return userDao.queryAlltiaojian(userId,userName,userTelephone);
    }
    //批量删除
    @Override
    public int deleteUser(String [] ids) {
        userDao.deleteUser(ids);
        return 1;
    }

    //模糊搜索
    @Override
    public List<User> queryUserLike(String userName){
        List<User> list=userDao.queryUserLike(userName);
        return list;
    }
    /**
     * 登录
     * @param userName
     * @param userPassword
     * @return
     */
    @Override
    @Transactional
    public User login(String userName, String userPassword) {
        return userDao.queryUserByNameAndPwd(userName,userPassword);
    }

    @Override
    @Transactional
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Transactional
    public int updateUser(String userId, String userName) {
        return userDao.updateUser(userId,userName);
    }
}
