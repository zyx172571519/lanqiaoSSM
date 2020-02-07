package com.taru.service.impl;

import com.taru.dao.UserRoleDao;
import com.taru.service.UserRoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public int insertUserRole(@Param("userId") String userId,@Param("roleId") String roleId) {
        userRoleDao.insertUserRole(userId,roleId);
        return 1;
    }
}
