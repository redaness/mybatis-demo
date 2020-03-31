package com.reda.bootstrap;

import com.reda.entity.User;
import com.reda.mapper.Test2Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SenondCacheBootStrap {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过配置文件build
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        Test2Mapper mapper = sqlSession.getMapper(Test2Mapper.class);
        User user = mapper.findById(1);
        System.out.println(user);
        sqlSession.close();
        // 重新开一个SqlSession 测试二级缓存
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

        Test2Mapper mapper2 = sqlSession2.getMapper(Test2Mapper.class);
        User user2 = mapper2.findById(1);
        User user3 = mapper2.findById(1);
        User user4 = mapper2.findById(1);
        User user5 = mapper2.findById(1);
        User user6 = mapper2.findById(1);
        System.out.println(user2);
        sqlSession2.close();
    }
}
