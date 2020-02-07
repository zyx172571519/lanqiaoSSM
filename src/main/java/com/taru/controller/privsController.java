package com.taru.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taru.model.Privs;
import com.taru.service.impl.PrivsServiceImpl;
import com.taru.util.Constants;
import com.taru.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class privsController {

    @Autowired
    PrivsServiceImpl privsService;



    /**
     * 查询所有权限
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/query/allPrivs")
    public  Object queryAllPrivs(Integer pageNum,Integer pageSize ){
        JsonResult result=null;
        try{
            PageHelper.startPage(pageNum,pageSize);
            List list=privsService.queryAllPrivs();
            PageInfo pageInfo=new PageInfo(list);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",pageInfo);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    /**
     * 查询用户登录菜单
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/query/caidan")
    public Object queryAll(String userId){
        JsonResult result=null;
        try{
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",privsService.treecaidan(userId));
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    //添加权限
    @ResponseBody
    @RequestMapping("/api/insert/PrivsOne")
    public Object insertPrivsOne(@Param("privsName") String privsName, @Param("privsFather") String privsFather, @Param("privsSon") String privsSon){
        JsonResult result=null;
        try{
            int row=privsService.insertPrivsOne(privsName,privsFather,privsSon);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",row);
        }catch (Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    /**
     * 根据角色id查询角色所有权限
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/query/PrivsByRoleId")
    public Object queryPrivsByRoleId(String roleId){
        JsonResult result=null;
        try{
            List<Privs> privs =privsService.queryPrivsByRoleId(roleId);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",privs);
        }catch (Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }
}
