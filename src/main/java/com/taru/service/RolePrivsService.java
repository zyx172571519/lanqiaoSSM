package com.taru.service;

import org.apache.ibatis.annotations.Param;

public interface RolePrivsService {

    int insertRolePrivsOne(@Param("roleId") String roleId,@Param("privsId") String privsId);

    int deletePrivsByRoleId(@Param("rolePrivs") String rolePrivs,@Param("roleId") String roleId);
}
