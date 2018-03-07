package com.longjuan.dao;

import com.longjuan.dao.provider.WithdrawDynaSqlProvider;
import com.longjuan.domain.Withdraw;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface WithdrawDao {

    @Select("SELECT * FROM " + BamsConstants.WITHDRAWTABLE + " ")
    @Results({
            @Result(column = "wid", property = "wid"),
            @Result(column = "wtype", property = "wtype"),
            @Result(column = "wtime", property = "wtime"),
            @Result(column = "wmoney", property = "wmoney"),
            @Result(column = "wbalance", property = "wbalance"),
            @Result(column = "aid", property = "account.aid"),
    })
    List<Withdraw> selectAllWithdraw();

    @Select("SELECT * FROM " + BamsConstants.WITHDRAWTABLE + " WHERE aid = #{aid}")
    @Results({
            @Result(column = "wid", property = "wid"),
            @Result(column = "wtype", property = "wtype"),
            @Result(column = "wtime", property = "wtime"),
            @Result(column = "wmoney", property = "wmoney"),
            @Result(column = "wbalance", property = "wbalance"),
            @Result(column = "aid", property = "account.aid")
    })
    List<Withdraw> selectWithdrawByAid(Integer aid);

    @Delete("DELETE FROM " + BamsConstants.WITHDRAWTABLE + " WHERE wid = #{wid}")
    void deleteByWid(Integer wid);

    @Delete("DELETE FROM " + BamsConstants.WITHDRAWTABLE + " WHERE aid = #{aid}")
    void deleteByAid(Integer aid);

    @SelectProvider(type = WithdrawDynaSqlProvider.class, method = "insertWithdraw")
    void save(Withdraw withdraw);

    @SelectProvider(type = WithdrawDynaSqlProvider.class, method = "updateWithdraw")
    void update(Withdraw withdraw);
}
