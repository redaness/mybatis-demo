package learn.reda.dao;

import learn.reda.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyMapper {

  @Select("SELECT * FROM t_customer WHERE id = #{id:INTEGER}")
  Customer findCustomer(@Param("id") long id);
}
