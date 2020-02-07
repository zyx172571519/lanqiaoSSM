package com.taru.controller;

import com.taru.model.RolePrivs;
import com.taru.service.impl.RolePrivsServiceImpl;
import com.taru.service.impl.RoleServiceImpl;
import com.taru.util.Constants;
import com.taru.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class roleprivsController {
    @Autowired
    RolePrivsServiceImpl rolePrivsService;

    /**
     * 给角色添加权限
     * @param roleId
     * @param privsId
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/insert/roleprivs")
    public Object insertRolePrivsOne(@Param("roleId") String roleId,@Param("privsId") String privsId){
        JsonResult result=null;
        try{
            int row=rolePrivsService.insertRolePrivsOne(roleId,privsId);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",row);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

    /**
     * 删除角色的权限
     * @param rolePrivs
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/delete/rolePrivs")
    public Object deletePrivsByRoleId(@Param("rolePrivs") String rolePrivs,@Param("roleId") String roleId){
        JsonResult result=null;
        try{
            int row=rolePrivsService.deletePrivsByRoleId(rolePrivs,roleId);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",row);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }
}
