package com.reda.bootstrap;

import com.reda.mapper.Test2Mapper;
import com.reda.mapper.TestMapper;
import com.reda.utils.DataSourceUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

public class XmlBootstrap {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过配置文件build
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        Test2Mapper mapper = sqlSession.getMapper(Test2Mapper.class);

        System.out.println(mapper.findById(1));

        sqlSession.close();



    }
}
