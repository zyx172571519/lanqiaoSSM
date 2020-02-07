package com.taru.service.impl;

import com.taru.dao.RoleDao;
import com.taru.dao.RolePrivsDao;
import com.taru.model.RolePrivs;
import com.taru.service.RolePrivsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolePrivsServiceImpl implements RolePrivsService {
    @Autowired
    RolePrivsDao rolePrivsDao;

    @Override
    public int insertRolePrivsOne(@Param("roleId") String roleId,@Param("privsId") String privsId) {
        rolePrivsDao.insertRolePrivsOne(roleId,privsId);
        return 1;
    }

    @Override
    public int deletePrivsByRoleId(String rolePrivs, String roleId) {
        rolePrivsDao.deletePrivsByRoleId(rolePrivs,roleId);
        return 1;
    }
}
