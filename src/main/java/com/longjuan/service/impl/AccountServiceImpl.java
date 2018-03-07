package com.longjuan.service.impl;

import com.longjuan.dao.AccountDao;
import com.longjuan.domain.Account;
import com.longjuan.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(propagation= Propagation.REQUIRED, isolation= Isolation.DEFAULT)
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        LOGGER.info("execute findAllAccount()");
        return accountDao.selectAllAccount();
    }

    @Override
    public List<Account> findselectAccountByCid(Integer cid) {
        LOGGER.info("execute findselectAccountByCid()");
        return accountDao.selectAccountByCid(cid);
    }

    @Override
    public void addAccount(Account account) {
        LOGGER.info("execute addAccount()");
        accountDao.save(account);
    }

    @Override
    public void modifyAccount(Account account) {
        LOGGER.info("execute modifyAccount()");
        accountDao.update(account);
    }

    @Override
    public void removeAccountByAid(Integer aid) {
        LOGGER.info("execute removeAccountByAid()");
        LOGGER.info(aid);
        accountDao.deleteById(aid);
    }


}
