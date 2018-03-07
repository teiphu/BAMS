package com.longjuan.service;

import com.longjuan.domain.Deposit;

import java.util.List;

public interface DepositService {

    List<Deposit> findAllDeposit();

    List<Deposit> findDepositByAid(Integer aid);

    void addDeposit(Deposit deposit);

    void modifyDeposit(Deposit deposit);

    void removeDepositByDid(Integer did);

    void removeDepositByAid(Integer aid);
}
