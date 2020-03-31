package com.reda.utils;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.sql.DataSource;

import static com.reda.utils.PropertiesUtils.get;

public class DataSourceUtils {
    public static DataSource dataSource1() {
        return new PooledDataSource(get("datasource.driver-class-name")
            , get("datasource.jdbc-url")
            , get("datasource.username")
            , get("datasource.password"));
    }
}
