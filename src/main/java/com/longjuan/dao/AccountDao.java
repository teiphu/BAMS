package com.longjuan.dao;

import com.longjuan.dao.provider.AccountDynaSqlProvider;
import com.longjuan.domain.Account;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    /**
     * 查找所有的账号
     * @return
     */
    @Select("SELECT * FROM " + BamsConstants.ACCOUNTTABLE + " ")
    @Results({
            @Result(column = "aid", property = "aid"),
            @Result(column = "cbalance", property = "cbalance"),
            @Result(column = "climit", property = "climit"),
            @Result(column = "ctype", property = "ctype"),
            @Result(column = "cid", property = "customer.cid")
    })
    List<Account> selectAllAccount();

    /**
     * 根据客户ID查找所有
     * @return
     */
    @Select("SELECT * FROM " + BamsConstants.ACCOUNTTABLE + " WHERE cid = #{cid}")
    @Results({
            @Result(column = "aid", property = "aid"),
            @Result(column = "cbalance", property = "cbalance"),
            @Result(column = "climit", property = "climit"),
            @Result(column = "ctype", property = "ctype"),
            @Result(column = "cid", property = "customer.cid")
    })
    List<Account> selectAccountByCid(Integer cid);

    /*
    @Select("SELECT * FROM " + BamsConstants.ACCOUNTTABLE + " WHERE aid = aid")
    @Results({
            @Result(id = true, column = "aid", property = "aid"),
            @Result(column = "cbalance", property = "cbalance"),
            @Result(column = "climit", property = "climit"),
            @Result(column = "ctype", property = "ctype"),
            @Result(column = "cid", property = "customer",
                    one = @One(select = "com.longjuan.dao.CustomerDao.selectByCid",
                            fetchType = FetchType.EAGER))
    })
    Account selectAccountByAid(Integer aid);
     */

    //    根据账号id删除账号
    @Delete("DELETE FROM " + BamsConstants.ACCOUNTTABLE + " WHERE aid = #{aid}")
    void deleteById(Integer aid);

    //    动态插入账号
    @Results({
            @Result(column = "aid", property = "aid"),
            @Result(column = "cbalance", property = "cbalance"),
            @Result(column = "climit", property = "climit"),
            @Result(column = "ctype", property = "ctype"),
            @Result(column = "cid", property = "customer.cid")
    })
    @SelectProvider(type = AccountDynaSqlProvider.class, method = "insertAccount")
    void save(Account account);

    //    动态修改账号
    @SelectProvider(type = AccountDynaSqlProvider.class, method = "updateAccount")
    void update(Account account);

}
