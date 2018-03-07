package com.longjuan.service;

import com.longjuan.domain.Customer;

import java.util.List;

public interface BamsService {

    Customer login(String cname, String cpassword);

    Customer findCustomerByCid(Integer cid);

    List<Customer> findAllCustomer();

    /**
     * 添加客户
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     * 修改客户
     * @param customer
     */
    void modifyCustomer(Customer customer);

    /**
     * 根据id删除客户
     * @param cid
     */
    void removeCustomerByCid(Integer cid);
}
