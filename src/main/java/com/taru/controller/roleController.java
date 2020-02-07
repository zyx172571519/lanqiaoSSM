package com.taru.controller;

import com.taru.model.Role;
import com.taru.service.RoleService;
import com.taru.service.impl.RoleServiceImpl;
import com.taru.util.Constants;
import com.taru.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class roleController {

    @Autowired
    RoleServiceImpl roleService;

    /**
     * 查询所有角色
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/query/allprivs")
    public Object queryAllRole(){
        JsonResult result=null;
        try{
            List list=roleService.queryAllRole();
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",list);
        }catch (Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    /**
     * 添加角色
     * @param roleName
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/insert/role")
    public Object insertRoleOne(String roleName){
        JsonResult result=null;
        try{
            int row=roleService.insertRoleOne(roleName);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",row);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }
}
