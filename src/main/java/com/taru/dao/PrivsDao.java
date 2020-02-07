package com.taru.dao;

import com.taru.model.Privs;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivsDao {

    public List<Privs> queryAllPrivs();

    public List<Privs> treecaidan(String userId);

    int insertPrivsOne(@Param("privsName") String privsName,@Param("privsFather") String privsFather,@Param("privsSon") String privsSon);

    List<Privs> queryPrivsByRoleId(String roleId);
}
