package com.taru.service.impl;

import com.taru.dao.RoleDao;
import com.taru.model.Role;
import com.taru.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    /**
     * 查询所有角色
     * @return
     */
    @Override
    @Transactional
    public List<RoleDao> queryAllRole() {
        return roleDao.queryAllRole();
    }

    /**
     * 添加角色
     * @param roleName
     * @return
     */
    @Override
    public int insertRoleOne(String roleName) {
        roleDao.insertRoleOne(roleName);
        return 1;
    }


}
