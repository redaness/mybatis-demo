package com.reda.bootstrap;

import com.reda.entity.User;
import com.reda.mapper.Test2Mapper;
import org.apache.ibatis.session.SqlSession;

public class ErrorSecondCacheBootStrap {
    public static void main(String[] args) {
        try(SqlSession session = BaseBootStrap.getSession(true)) {
            Test2Mapper mapper = session.getMapper(Test2Mapper.class);

            User user = mapper.findById(1);
            user.setName("cache");
            System.out.println(user);
        }

        // 这里的二级缓存打开了，但是没有命中，的原因是他们不是一个SqlSessionFactory下面的，不是同一个作用域的
        try(SqlSession session = BaseBootStrap.getSession(true)) {
            Test2Mapper mapper = session.getMapper(Test2Mapper.class);

            User user = mapper.findById(1);
            System.out.println(user);
        }
    }
}
