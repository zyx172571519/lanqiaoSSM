package com.taru.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import javax.annotation.Resource;
import java.io.InputStream;

public class Sessionutil {

    private static SqlSessionFactory sqlSessionFactory;

    static
    {
        String resource="mybatis-config.xml";
        InputStream inputStream=null;
        try{
            inputStream= Resources.getResourceAsStream(resource);
        }catch(Exception e){
            e.printStackTrace();
        }
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSession opSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
