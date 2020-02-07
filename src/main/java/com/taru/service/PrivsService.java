package com.taru.service;

import com.taru.model.Privs;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrivsService {

    List<Privs> queryAllPrivs();

    List<Privs> treecaidan(String userId);

    int insertPrivsOne(@Param("privsName") String privsName, @Param("privsFather") String privsFather, @Param("privsSon") String privsSon);

    List<Privs> queryPrivsByRoleId(String roleId);
}
