package com.longjuan.domain;

import java.io.Serializable;
import java.util.Date;

public class Withdraw implements Serializable {
    private static final long serialVersionUID = 2285712825932537255L;

    private Integer wid;
    private Account account;
    private String wtype;
    private Date wtime;
    private String wmoney;
    private String wbalance;

    public Withdraw() {
        super();
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getWtype() {
        return wtype;
    }

    public void setWtype(String wtype) {
        this.wtype = wtype;
    }

    public Date getWtime() {
        return wtime;
    }

    public void setWtime(Date wtime) {
        this.wtime = wtime;
    }

    public String getWmoney() {
        return wmoney;
    }

    public void setWmoney(String wmoney) {
        this.wmoney = wmoney;
    }

    public String getWbalance() {
        return wbalance;
    }

    public void setWbalance(String wbalance) {
        this.wbalance = wbalance;
    }
}
