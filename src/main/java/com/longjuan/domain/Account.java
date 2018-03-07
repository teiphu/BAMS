package com.longjuan.domain;

import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = 5783047673623056928L;

    private Integer aid;
    private Customer customer;
    private String cbalance;
    private String climit;
    private String ctype;

    public Account() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCbalance() {
        return cbalance;
    }

    public void setCbalance(String cbalance) {
        this.cbalance = cbalance;
    }

    public String getClimit() {
        return climit;
    }

    public void setClimit(String climit) {
        this.climit = climit;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
}
