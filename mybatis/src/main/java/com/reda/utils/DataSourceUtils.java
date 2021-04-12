package com.reda.utils;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;
import javax.sql.XADataSource;

import static com.reda.utils.PropertiesUtils.get;

public class DataSourceUtils {
    public static DataSource dataSource1() {
        return new PooledDataSource(get("datasource.driver-class-name")
            , get("datasource.jdbc-url")
            , get("datasource.username")
            , get("datasource.password"));
    }

    public static XADataSource xaDataSource(String url, String uer, String password) {
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setUrl(url);
        xaDataSource.setUser(uer);
        xaDataSource.setPassword(password);

        return xaDataSource;

    }


}
