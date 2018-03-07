package com.longjuan.service;

import com.longjuan.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAllAccount();

    List<Account> findselectAccountByCid(Integer cid);

    void addAccount(Account account);

    void modifyAccount(Account account);

    void removeAccountByAid(Integer aid);
}
