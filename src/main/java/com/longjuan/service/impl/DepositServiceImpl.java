package com.longjuan.service.impl;

import com.longjuan.dao.DepositDao;
import com.longjuan.domain.Deposit;
import com.longjuan.service.DepositService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.DEFAULT)
@Service("depositService")
public class DepositServiceImpl implements DepositService {

    private static final Logger LOGGER = Logger.getLogger(DepositServiceImpl.class);

    @Autowired
    private DepositDao depositDao;

    @Override
    public List<Deposit> findAllDeposit() {
        LOGGER.info("execute findAllDeposit()");
        return depositDao.selectAllDeposit();
    }

    @Override
    public List<Deposit> findDepositByAid(Integer aid) {
        LOGGER.info("execute findDepositByAid()");
        return depositDao.selectDepositByAid(aid);
    }

    @Override
    public void addDeposit(Deposit deposit) {
        LOGGER.info("execute addDeposit()");
        depositDao.save(deposit);
    }

    @Override
    public void modifyDeposit(Deposit deposit) {
        LOGGER.info("execute modifyDeposit()");
        depositDao.update(deposit);
    }

    @Override
    public void removeDepositByDid(Integer did) {
        LOGGER.info("execute removeDepositByDid()");
        depositDao.deleteByDid(did);
    }

    @Override
    public void removeDepositByAid(Integer aid) {
        LOGGER.info("execute removeDepositByAid()");
        depositDao.deleteByAid(aid);
    }


}
