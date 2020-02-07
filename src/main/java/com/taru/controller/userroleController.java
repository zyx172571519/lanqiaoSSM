package com.taru.controller;

import com.github.pagehelper.Constant;
import com.taru.service.UserRoleService;
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
public class userroleController {

    @Autowired
    UserRoleService userRoleService;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/api/insert/userrole")
    public Object insertUserRole(@Param("userId") String userId,@Param("roleId") String roleId){
        JsonResult result=null;
        try{
            int row=userRoleService.insertUserRole(userId,roleId);
            result=new JsonResult(Constants.STATUS_SUCCESS,"成功",row);
        }catch(Exception e){
            result=new JsonResult(Constants.STATUS_ERROR,"失败");
        }
        return result;
    }

}
