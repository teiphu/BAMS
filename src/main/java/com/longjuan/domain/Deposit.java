package com.longjuan.domain;

import java.io.Serializable;
import java.util.Date;

public class Deposit implements Serializable {

    private static final long serialVersionUID = 1683386782450084894L;

    private Integer did;
    private Account account;
    private String dtype;
    private Date dtime;
    private String dmoney;
    private String dbalance;

    public Deposit() {
        super();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public Date getDtime() {
        return dtime;
    }

    public void setDtime(Date dtime) {
        this.dtime = dtime;
    }

    public String getDmoney() {
        return dmoney;
    }

    public void setDmoney(String dmoney) {
        this.dmoney = dmoney;
    }

    public String getDbalance() {
        return dbalance;
    }

    public void setDbalance(String dbalance) {
        this.dbalance = dbalance;
    }
}
