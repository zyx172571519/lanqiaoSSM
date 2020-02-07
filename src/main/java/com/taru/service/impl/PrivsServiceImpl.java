package com.taru.service.impl;
import com.taru.dao.PrivsDao;
import com.taru.model.Privs;
import com.taru.service.PrivsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrivsServiceImpl implements PrivsService {

    @Autowired
    PrivsDao privsDao;

    @Override
    @Transactional
    public List<Privs> queryAllPrivs() {
        return privsDao.queryAllPrivs();
    }

    @Override
    @Transactional
    public List<Privs> treecaidan(String userId) {
        return privsDao.treecaidan(userId);
    }

    @Override
    public int insertPrivsOne(@Param("privsName") String privsName, @Param("privsFather") String privsFather, @Param("privsSon") String privsSon) {
        privsDao.insertPrivsOne(privsName,privsFather,privsSon);
        return 1;
    }

    @Override
    public List<Privs> queryPrivsByRoleId(String roleId) {
        return privsDao.queryPrivsByRoleId(roleId);
    }
}
