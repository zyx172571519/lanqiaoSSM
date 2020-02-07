package com.taru.dao;

import com.taru.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public int deleteUserById(String userId);

    /**
     * 查询用户详细信息
     * @return
     */
    public User queryUserById(String userId);
    /**
     * 查询所有用户
     * @return
     */
    public List<User> queryAlluer();
    /**
     * 多条件查询
     * @param userId
     * @param userName
     * @param userTelephone
     * @return
     */
    public List<User> queryAlltiaojian(@Param("userId") String userId,@Param("userName") String userName,@Param("userTelephone") String userTelephone);

    //批量删除
    public int deleteUser(String [] ids);

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @return
     */
    public User queryUserByNameAndPwd(@Param("userName") String userName,@Param("userPassword") String userPassword);
    /**
     * 注册用户
     * @param user
     * @return
     */
    public int insertUser(User user);


    /**
     * 更改用户名
     * @param userId
     * @param userName
     * @return
     */
    public int updateUser(@Param("userId") String userId,@Param("userName") String userName);

    //模糊搜索
    public List<User> queryUserLike(String userName);


}
