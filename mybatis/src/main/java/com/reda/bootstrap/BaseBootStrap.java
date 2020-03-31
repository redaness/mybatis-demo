package com.reda.bootstrap;

import com.reda.mapper.TestMapper;
import com.reda.utils.DataSourceUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

public class BaseBootStrap {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        DataSource dataSource = DataSourceUtils.dataSource1();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment dev =  new Environment("dev", transactionFactory, dataSource);
        config.setEnvironment(dev);
        config.addMapper(TestMapper.class);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(config);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        System.out.println(testMapper.findNameById(1));
    }

    public static SqlSession getSession(boolean autoCommit) {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 通过配置文件build
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(autoCommit);
        return sqlSession;
    }
}
