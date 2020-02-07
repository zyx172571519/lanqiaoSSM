package com.taru.controller;

import com.taru.model.User;
import com.taru.service.impl.UserServiceImpl;
import com.taru.util.Constants;
import com.taru.util.JsonResult;
import com.taru.util.SecurityUtl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class userController {


    @Autowired
    UserServiceImpl userService;

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/delete/user/ById")
    public Object deleteUserById(String userId){
        JsonResult result=null;
        try{
            int row=userService.deleteUserById(userId);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",row);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    /**
     * 根据用户id查询用户详情
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/query/user/id")
    public Object queryUserById(String userId){
        JsonResult result=null;
        try{
            User user=userService.queryUserById(userId);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",user);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }
    /**
     * 查询所有用户
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/query/alluser")
    public Object queryAllUser(){
        JsonResult result=null;
        try{
            List<User> list=userService.queryAlluer();
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",list);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"成功");
        }
        return result;
    }
    /**
     * 多条件查询
     * @param userId
     * @param userName
     * @param userTelephone
     * @return
     */
    @ResponseBody
    @RequestMapping("/tiaojian")
    public Object queryTiaojian(@Param("userId") String userId,@Param("userName") String userName,@Param("userTelephone") String userTelephone){
        JsonResult result=null;
        try{
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功", userService.queryAlltiaojian(userId,userName,userTelephone));
        }catch (Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/delete/user")
    public Object deleteUser(String [] ids){
        JsonResult result=null;
        try{
            System.out.println(ids.toString());
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",userService.deleteUser(ids));
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }
    /**
     * 登录
     * @param userName
     * @param userPassword
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/login")
    public Object login(@Param("userName") String userName, @Param("userPassword") String userPassword, HttpServletResponse response){
        JsonResult result=null;
        try{
            User user=userService.login(userName,userPassword);
            String token_jSessionId= SecurityUtl.getMd5String(userName);
            redisTemplate.opsForHash().put("loginUserKey",token_jSessionId,user.getUserId());
//            String token_jSessionId=String.valueOf(System.currentTimeMillis());
//            redisTemplate.opsForValue().set("token_jSessionId",user.getUserId());
            Cookie cookie=new Cookie("token",token_jSessionId);
            cookie.setPath("/");
            cookie.setMaxAge(60*60*60);
            response.addCookie(cookie);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",user);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }


    /**
     * 用户模糊搜索
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/query/User/like")
    public Object queryUserLike(String userName){
        JsonResult result=null;
        try{
            List<User> user=userService.queryUserLike(userName);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",user);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert/user")
    public Object insertUser(User user){
        JsonResult result=null;
        try{
            int row=userService.insertUser(user);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",row);
        }catch(Exception e){
            e.printStackTrace();
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("/api/update/user")
    public Object updateUser(@Param("userId") String userId,@Param("userName") String userName){
        JsonResult result=null;
        try{
            int row=userService.updateUser(userId,userName);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",row);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return  result;
    }

}
