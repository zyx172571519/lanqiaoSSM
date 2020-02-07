package com.taru.service;

import org.apache.ibatis.annotations.Param;

public interface UserRoleService {
    //给用户添加角色
    int insertUserRole(@Param("userId") String userId,@Param("roleId") String roleId);
}
