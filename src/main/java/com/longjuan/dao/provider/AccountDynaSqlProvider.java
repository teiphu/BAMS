package com.longjuan.dao.provider;

import com.longjuan.domain.Account;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.jdbc.SQL;
import org.apache.log4j.Logger;

public class AccountDynaSqlProvider {

    private static final Logger LOGGER = Logger.getLogger(AccountDynaSqlProvider.class);

    public String insertAccount(final Account account) {
        LOGGER.info("execute insertAccount()");
        LOGGER.info(account.getAid());
        return new SQL() {
            {
                INSERT_INTO(BamsConstants.ACCOUNTTABLE);
                if (account.getCustomer() != null) {
                    VALUES("cid", "#{customer.cid}");
                }
                if (account.getCbalance() != null && !account.getCbalance().equals("")) {
                    VALUES("cbalance", "#{cbalance}");
                }
                if (account.getClimit() != null && !account.getClimit().equals("")) {
                    VALUES("climit", "#{climit}");
                }
                if (account.getCtype() != null && !account.getCtype().equals("")) {
                    VALUES("ctype", "#{ctype}");
                }
            }
        }.toString();
    }

    public String updateAccount(final Account account) {
        LOGGER.info("execute updateAccount()");
        return new SQL(){
            {
                UPDATE(BamsConstants.ACCOUNTTABLE);
                if (account.getCustomer() != null) {
                    SET(" cid = #{customer.id}");
                }
                if (account.getCbalance() != null && !account.getCbalance().equals("")) {
                    SET(" cbalance = #{cbalance} ");
                }
                if (account.getClimit() != null && !account.getClimit().equals("")) {
                    SET(" climit = #{climit} ");
                }
                if (account.getCtype() != null && !account.getCtype().equals("")) {
                    SET(" ctype = #{ctype} ");
                }
                WHERE(" aid = #{aid}");
            }
        }.toString();
    }
}
