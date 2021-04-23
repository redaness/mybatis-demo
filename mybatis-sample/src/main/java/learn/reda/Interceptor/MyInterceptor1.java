package learn.reda.Interceptor;

import learn.reda.dao.CustomerMapper;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts({
    @Signature(type = Executor.class, method = "query", args = {
       MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class MyInterceptor1 implements Interceptor {

  private Log logger = LogFactory.getLog(MyInterceptor1.class);

  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    logger.debug("intercept CustomerMapper#find");
    return invocation.proceed();
  }
}
