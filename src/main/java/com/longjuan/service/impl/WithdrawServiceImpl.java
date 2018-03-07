package com.longjuan.service.impl;

import com.longjuan.dao.WithdrawDao;
import com.longjuan.domain.Withdraw;
import com.longjuan.service.WithdrawService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.DEFAULT)
@Service("withdrawService")
public class WithdrawServiceImpl implements WithdrawService {

    private static final Logger LOGGER = Logger.getLogger(WithdrawServiceImpl.class);

    @Autowired
    private WithdrawDao withdrawDao;

    @Override
    public List<Withdraw> findAllWithdraw() {
        LOGGER.info("execute findAllWithdraw()");
        return withdrawDao.selectAllWithdraw();
    }

    @Override
    public List<Withdraw> findWithdrawByAid(Integer aid) {
        LOGGER.info("execute findWithdrawByAid()");
        return withdrawDao.selectWithdrawByAid(aid);
    }

    @Override
    public void addWithdraw(Withdraw withdraw) {
        LOGGER.info("execute addWithdraw()");
        withdrawDao.save(withdraw);
    }

    @Override
    public void modifyWithdraw(Withdraw withdraw) {
        LOGGER.info("execute modifyWithdraw()");
        withdrawDao.update(withdraw);
    }

    @Override
    public void removeWithdrawByWid(Integer wid) {
        LOGGER.info("execute removeWithdrawByWid()");
        withdrawDao.deleteByWid(wid);
    }

    @Override
    public void removeWithdrawByAid(Integer aid) {
        LOGGER.info("execute removeWithdrawByAid()");
        withdrawDao.deleteByAid(aid);
    }
}
