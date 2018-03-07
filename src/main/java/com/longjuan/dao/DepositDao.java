package com.longjuan.dao;

import com.longjuan.dao.provider.DepositDynaSqlProvider;
import com.longjuan.domain.Deposit;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DepositDao {

    @Select("SELECT * FROM " + BamsConstants.DEPOSITTABLE + " ")
    @Results({
            @Result(column = "did", property = "did"),
            @Result(column = "dtype", property = "dtype"),
            @Result(column = "dtime", property = "dtime"),
            @Result(column = "dmoney", property = "dmoney"),
            @Result(column = "dbalance", property = "dbalance"),
            @Result(column = "aid", property = "account.aid")
    })
    List<Deposit> selectAllDeposit();

    @Select("SELECT * FROM " + BamsConstants.DEPOSITTABLE + " WHERE aid = #{aid}")
    @Results({
            @Result(column = "did", property = "did"),
            @Result(column = "dtype", property = "dtype"),
            @Result(column = "dtime", property = "dtime"),
            @Result(column = "dmoney", property = "dmoney"),
            @Result(column = "dbalance", property = "dbalance"),
            @Result(column = "aid", property = "account.aid")
    })
    List<Deposit> selectDepositByAid(Integer aid);

    @Delete("DELETE FROM " + BamsConstants.DEPOSITTABLE + " WHERE did = #{did}")
    void deleteByDid(Integer did);

    @Delete("DELETE FROM " + BamsConstants.DEPOSITTABLE + " WHERE aid = #{aid}")
    void deleteByAid(Integer aid);

    @SelectProvider(type = DepositDynaSqlProvider.class, method = "insertDeposit")
    void save(Deposit deposit);

    @SelectProvider(type = DepositDynaSqlProvider.class, method = "updateDeposit")
    void update(Deposit deposit);
}
