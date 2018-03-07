package com.longjuan.dao.provider;

import com.longjuan.domain.Withdraw;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.jdbc.SQL;
import org.apache.log4j.Logger;

public class WithdrawDynaSqlProvider {

    private static final Logger LOGGER = Logger.getLogger(WithdrawDynaSqlProvider.class);

    public String insertWithdraw(final Withdraw withdraw) {
        LOGGER.info("excute insertWithdraw()");
        return new SQL() {
            {
                INSERT_INTO(BamsConstants.WITHDRAWTABLE);
                if (withdraw.getAccount() != null) {
                    VALUES("aid", "#{account.aid}");
                }
                if (withdraw.getWtype() != null && !withdraw.getWtype().equals("")) {
                    VALUES("wtype", "#{wtype}");
                }
                if (withdraw.getWmoney() != null && !withdraw.getWmoney().equals("")) {
                    VALUES("wmoney", "#{wmoney}");
                }
                if (withdraw.getWbalance() != null && !withdraw.getWbalance().equals("")) {
                    VALUES("wbalance", "#{wbalance}");
                }
            }
        }.toString();
    }

    public String updateWithdraw(final Withdraw withdraw) {
        LOGGER.info("excute updateWithdraw()");
        return new SQL() {
            {
                UPDATE(BamsConstants.WITHDRAWTABLE);
                if (withdraw.getAccount() != null) {
                    SET(" aid = #{account.aid} ");
                }
                if (withdraw.getWtype() != null && !withdraw.getWtype().equals("")) {
                    SET(" wtype = #{wtype} ");
                }
                if (withdraw.getWmoney() != null && !withdraw.getWmoney().equals("")) {
                    SET(" wmoney = #{wmoney} ");
                }
                if (withdraw.getWbalance() != null && !withdraw.getWbalance().equals("")) {
                    SET(" wbalance = #{wbalance} ");
                }
                WHERE(" wid = #{wid} ");
            }
        }.toString();
    }
}
