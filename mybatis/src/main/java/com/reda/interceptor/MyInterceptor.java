package com.reda.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "commit", args = boolean.class)
})
public class MyInterceptor implements Interceptor {

    private Properties props = new Properties();

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println(props.getProperty("value1"));
        System.out.printf("intercepts method: %s args num: %s\n", invocation.getMethod().getName(),invocation.getArgs().length);
        return invocation.proceed();
    }

    @Override
    public void setProperties(Properties properties) {
        this.props = properties;
    }
}
