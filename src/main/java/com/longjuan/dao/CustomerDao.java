package com.longjuan.dao;

import com.longjuan.dao.provider.CustomerDynaSqlProvider;
import com.longjuan.domain.Customer;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface CustomerDao {

    //根据名字和密码查询员工
    @Select("select * from " + BamsConstants.CUSTOMERTABLE + " where cname = #{cname} and cpassword = #{cpassword}")
    Customer selectByNameAndPassword(
            @Param("cname") String cname,
            @Param("cpassword") String cpassword);

    @Select("SELECT * FROM " + BamsConstants.CUSTOMERTABLE + " WHERE cid = #{cid}")
    Customer selectByCid(Integer cid);

    @Select("SELECT * FROM " + BamsConstants.CUSTOMERTABLE + " ")
    List<Customer> selectAllCustomer();

    @SelectProvider(type = CustomerDynaSqlProvider.class, method = "insertCustomer")
    void save(Customer customer);

    @SelectProvider(type = CustomerDynaSqlProvider.class, method = "updateCustomer")
    void update(Customer customer);

//    根据id删除用户
    @Delete("delete from " + BamsConstants.CUSTOMERTABLE + " where cid = #{cid}")
    void deleteByCid(Integer cid);

}
