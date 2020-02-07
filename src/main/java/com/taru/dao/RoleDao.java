package com.taru.dao;

import com.taru.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    //查询所有角色
    public List<RoleDao> queryAllRole();

    //添加角色
    int insertRoleOne(String roleName);
}
