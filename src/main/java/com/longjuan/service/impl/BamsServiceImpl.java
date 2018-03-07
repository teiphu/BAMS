package com.longjuan.service.impl;

import com.longjuan.dao.CustomerDao;
import com.longjuan.domain.Customer;
import com.longjuan.service.BamsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.DEFAULT)
@Service("bamsService")
public class BamsServiceImpl implements BamsService {

    private static final Logger LOGGER = Logger.getLogger(BamsServiceImpl.class);

    @Autowired
    private CustomerDao customerDao;

    @Transactional(readOnly = true)
    @Override
    public Customer login(String cname, String cpassword) {
        LOGGER.info("execute login()");
        LOGGER.info(cname + "  " + cpassword);
        return customerDao.selectByNameAndPassword(cname, cpassword);
    }

    @Override
    public Customer findCustomerByCid(Integer cid) {
        LOGGER.info("execute findCustomerByCid()");
        LOGGER.info(cid);
        return customerDao.selectByCid(cid);
    }

    @Override
    public List<Customer> findAllCustomer() {
        LOGGER.info("execute findAllCustomer()");
        return customerDao.selectAllCustomer();
    }

    @Override
    public void addCustomer(Customer customer) {
        LOGGER.info("execute addCustomer()");
        customerDao.save(customer);
    }

    @Override
    public void modifyCustomer(Customer customer) {
        LOGGER.info("execute modifyCustomer()");
        customerDao.update(customer);
    }

    @Override
    public void removeCustomerByCid(Integer cid) {
        LOGGER.info("execute removeCustomerByCid()");
        customerDao.deleteByCid(cid);
    }

}
