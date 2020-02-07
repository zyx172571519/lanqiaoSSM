package com.taru.dao;

import com.taru.model.RolePrivs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePrivsDao {
    int insertRolePrivsOne(@Param("roleId") String roleId,@Param("privsId") String privsId);

    public int deletePrivsByRoleId(@Param("rolePrivs") String rolePrivs,@Param("roleId") String roleId);
}
