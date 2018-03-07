package com.longjuan.controller;

import com.longjuan.domain.Account;
import com.longjuan.domain.Customer;
import com.longjuan.domain.Withdraw;
import com.longjuan.service.AccountService;
import com.longjuan.service.WithdrawService;
import com.longjuan.util.BamsConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WithdrawController {

    private static final Logger LOGGER = Logger.getLogger(WithdrawController.class);

    @Autowired
    @Qualifier("withdrawService")
    private WithdrawService withdrawService;

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;
    
    @RequestMapping(value = "/withdraw/selectAllWithdraw.action")
    public String selectAllWithdraw(Model model) {
        LOGGER.info("excute selectAllWithdraw()");
        List<Withdraw> withdraws = withdrawService.findAllWithdraw();
        model.addAttribute("withdraws", withdraws);
        return "/selectAllWithdraw";
    }

    @RequestMapping(value = "/withdraw/selectWithdrawByAid.action")
    public String selectWithdrawByAid(HttpSession session,
                                      Model model) {
        LOGGER.info("excute selectWithdrawByAid()");
        Customer customer = (Customer) session.getAttribute(BamsConstants.CUSTOMER_SESSION);
        List<Account> accounts = accountService.findselectAccountByCid(customer.getCid());
        Account account = accounts.get(0);
        LOGGER.info("selectWithdrawByAid() --> " + account.getAid());
        List<Withdraw> withdraws = withdrawService.findWithdrawByAid(account.getAid());
        model.addAttribute("withdraws", withdraws);
        return "/selectAllWithdraw";
    }

    @RequestMapping(value = "/toWithdrawManage.action")
    public String skipToWithdrawManage() {
        LOGGER.info("execute skipToWithdrawManage()");
        return "/manageWithdraw";
    }

    @RequestMapping(value = "/withdraw/addWithdraw.action")
    public ModelAndView addWithdraw(@ModelAttribute Withdraw withdraw,
                                   @RequestParam("aid") String aid,
                                   HttpSession session,
                                   ModelAndView mv) {
        LOGGER.info("addWithdraw()");
        LOGGER.info(withdraw.getWmoney());
        LOGGER.info(aid);

        Customer customer = (Customer) session.getAttribute(BamsConstants.CUSTOMER_SESSION);
        //取出当前客户所有的账号
        List<Account> accounts = accountService.findselectAccountByCid(customer.getCid());
        //判断要取款的账号ID是否属于客户名下的账号
        Account account = new Account();
        for (Account account1 : accounts) {
            if (account1.getAid().equals(Integer.parseInt(aid))) {
                withdraw.setAccount(account1);
                account = account1;
                break;
            }
        }
        if (withdraw.getAccount() == null) {
            mv.setViewName("redirect:/withdraw/selectAllWithdraw.action");
            return mv;
        }
        LOGGER.info(withdraw.getAccount().getAid());
        LOGGER.info(account.getCbalance());
        //把要存款账号的余额转为float类型
        float cbalanceFloat = Float.parseFloat(account.getCbalance());
        LOGGER.info(cbalanceFloat);
        //把要存款的数额转为floatt类型
        float wmoneyFloat = Float.parseFloat(withdraw.getWmoney());
        LOGGER.info(wmoneyFloat);
        float sum = cbalanceFloat - wmoneyFloat;
        if (sum < 0.0) {
            mv.setViewName("redirect:/withdraw/selectAllWithdraw.action");
            return mv;
        }
        LOGGER.info(sum);
        String allBalance = Float.toString(sum);
        LOGGER.info(allBalance);
        withdraw.setWbalance(allBalance);
        withdrawService.addWithdraw(withdraw);
        mv.setViewName("redirect:/withdraw/selectAllWithdraw.action");
        return mv;
    }


}
