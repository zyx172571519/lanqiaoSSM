package com.taru.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao {

    int insertUserRole(@Param("userId") String userId,@Param("roleId") String roleId);

}
