package com.longjuan.service;

import com.longjuan.domain.Withdraw;

import java.util.List;

public interface WithdrawService {

    List<Withdraw> findAllWithdraw();

    List<Withdraw> findWithdrawByAid(Integer aid);

    void addWithdraw(Withdraw withdraw);

    void modifyWithdraw(Withdraw withdraw);

    void removeWithdrawByWid(Integer wid);

    void removeWithdrawByAid(Integer aid);
}
