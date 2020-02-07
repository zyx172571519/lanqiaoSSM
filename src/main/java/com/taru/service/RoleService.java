package com.taru.service;

import com.taru.dao.RoleDao;
import com.taru.model.Role;

import java.util.List;

public interface RoleService {

    public List<RoleDao> queryAllRole();

    int insertRoleOne(String roleName);
}
