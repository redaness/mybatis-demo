package com.reda.bootstrap;

import com.reda.entity.User;
import com.reda.mapper.Test2Mapper;
import com.reda.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;

public class FirstCacheBootStrap {
    public static void main(String[] args) {
        try(SqlSession session = BaseBootStrap.getSession(true)) {
            Test2Mapper mapper = session.getMapper(Test2Mapper.class);

            User user = mapper.findById(7);
            user.setName("cache");
            User user2 = mapper.findById(7);
            // 一级缓存命中
            System.out.println(user == user2);
            System.out.println(user2.getName());

            mapper.update(1);
            //更新后清除缓存
            User user3 = mapper.findById(1);
            System.out.println(user3);



        }
    }
}
