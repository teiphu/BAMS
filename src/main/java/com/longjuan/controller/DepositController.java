package com.longjuan.controller;

import com.longjuan.domain.Account;
import com.longjuan.domain.Customer;
import com.longjuan.domain.Deposit;
import com.longjuan.service.AccountService;
import com.longjuan.service.DepositService;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.executor.ReuseExecutor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DepositController {

    private static final Logger LOGGER = Logger.getLogger(DepositController.class);

    @Autowired
    @Qualifier("depositService")
    private DepositService depositService;

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @RequestMapping(value = "/deposit/selectAllDeposit.action")
    public String selectAllDeposit(Model model) {
        LOGGER.info("excute selectAllDeposit()");
        List<Deposit> deposits = depositService.findAllDeposit();
        model.addAttribute("deposits", deposits);
        return "/selectAllDeposit";
    }

    @RequestMapping(value = "/deposit/selectDepositByAid.action")
    public String selectDepositByAid(HttpSession session,
                                     Model model) {
        LOGGER.info("excute selectDepositByAid()");
        Customer customer = (Customer) session.getAttribute(BamsConstants.CUSTOMER_SESSION);
        List<Account> accounts = accountService.findselectAccountByCid(customer.getCid());
        Account account = accounts.get(0);
        LOGGER.info("selectDepositByAid() --> " + account.getAid());
        List<Deposit> deposits = depositService.findDepositByAid(account.getAid());
        model.addAttribute("deposits", deposits);
        return "/selectAllDeposit";
    }

    @RequestMapping(value = "/toDepositManage.action")
    public String skipToDepositManage() {
        LOGGER.info("execute skipToDepositManage()");
        return "/manageDeposit";
    }

    @RequestMapping(value = "/deposit/addDeposit.action")
    public ModelAndView addDeposit(@ModelAttribute Deposit deposit,
                                   @RequestParam("aid") String aid,
                                   HttpSession session,
                                   ModelAndView mv) {
        LOGGER.info("addDeposit()");
        LOGGER.info(deposit.getDmoney());
        LOGGER.info(aid);

        if (deposit.getAccount() != null) {
            LOGGER.info(deposit.getAccount().getAid());
        } else {
            LOGGER.info("deposit.getAccount is null");
        }
        Customer customer = (Customer) session.getAttribute(BamsConstants.CUSTOMER_SESSION);
        List<Account> accounts = accountService.findselectAccountByCid(customer.getCid());
        for (Account account2 : accounts) {
            LOGGER.info(account2.getAid());
        }
        //判断要存款的账号ID是否属于客户名下的账号
        Account account = new Account();
        for (Account account1 : accounts) {
            if (account1.getAid().equals(Integer.parseInt(aid))) {
                deposit.setAccount(account1);
                account = account1;
                break;
            }
        }
        if (deposit.getAccount() == null) {
            mv.setViewName("redirect:/deposit/selectAllDeposit.action");
            return mv;
        }
        LOGGER.info(deposit.getAccount().getAid());
        LOGGER.info(account.getCbalance());
        //计算存款后的余额
        float cbalanceInt = Float.parseFloat(account.getCbalance());//Integer.valueOf(account.getCbalance()).intValue();
        LOGGER.info(cbalanceInt);
        float dmoneyInt = Float.parseFloat(deposit.getDmoney());//Integer.valueOf(deposit.getDmoney()).intValue();
        LOGGER.info(dmoneyInt);
        float sum = cbalanceInt + dmoneyInt;
        String allBalance = Float.toString(sum);
        LOGGER.info(allBalance);
        deposit.setDbalance(allBalance);
        depositService.addDeposit(deposit);
        mv.setViewName("redirect:/deposit/selectAllDeposit.action");
        return mv;
    }


}

