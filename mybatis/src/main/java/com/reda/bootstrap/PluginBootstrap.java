package com.reda.bootstrap;

import com.reda.entity.User;
import com.reda.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;

public class PluginBootstrap {

    public static void main(String[] args) {
        try(SqlSession session = BaseBootStrap.getSession(true)) {
            TestMapper mapper = session.getMapper(TestMapper.class);
            User user = new User("gew",66);
            mapper.insert(user);
            System.out.printf("insert id %d\n", user.getId());
//            System.out.println(mapper.findById(user.getId()));
            //事务回滚和提交是在close方法中执行的user.getId()
        }
    }

}
