package com.longjuan.dao.provider;

import com.longjuan.domain.Deposit;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.jdbc.SQL;
import org.apache.log4j.Logger;

public class DepositDynaSqlProvider {

    private static final Logger LOGGER = Logger.getLogger(DepositDynaSqlProvider.class);

    public String insertDeposit(final Deposit deposit) {
        LOGGER.info("execute insertDeposit()");
        return new SQL() {
            {
                INSERT_INTO(BamsConstants.DEPOSITTABLE);
                if (deposit.getAccount() != null) {
                    VALUES("aid", "#{account.aid}");
                }
                if (deposit.getDtype() != null && !deposit.getDtype().equals("")) {
                    VALUES("dtype", "#{dtype}");
                }
                if (deposit.getDmoney() != null && !deposit.getDmoney().equals("")) {
                    VALUES("dmoney", "#{dmoney}");
                }
                if (deposit.getDbalance() != null && !deposit.getDbalance().equals("")) {
                    VALUES("dbalance", "#{dbalance}");
                }
            }
        }.toString();
    }

    public String updateDeposit(final Deposit deposit) {
        return new SQL(){
            {
                UPDATE(BamsConstants.DEPOSITTABLE);
                if (deposit.getAccount() != null) {
                    SET(" aid = #{account.aid} ");
                }
                if (deposit.getDtype() != null && !deposit.getDtype().equals("")) {
                    SET(" dtype = #{dtype} ");
                }
                if (deposit.getDmoney() != null && !deposit.getDmoney().equals("")) {
                    SET(" dmoney = #{dmoney} ");
                }
                if (deposit.getDbalance() != null && !deposit.getDbalance().equals("")) {
                    SET(" dbalance = #{dbalance} ");
                }
                WHERE(" did = #{did} ");
            }
        }.toString();
    }
}
