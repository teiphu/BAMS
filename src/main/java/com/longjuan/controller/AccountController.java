package com.longjuan.controller;

import com.longjuan.domain.Account;
import com.longjuan.domain.Customer;
import com.longjuan.service.AccountService;
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

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountController {

    private static final Logger LOGGER = Logger.getLogger(AccountController.class);

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @RequestMapping(value = "/account/selectAllAccount.action")
    public String selectAllAccount(Model model) {
        LOGGER.info("excute selectAllAccount()");
        List<Account> accounts = accountService.findAllAccount();
        LOGGER.info(accounts.toString());
        model.addAttribute("accounts", accounts);
        return "/selectAllAccount";
    }

    @RequestMapping(value = "/account/selectAccountByCid.action")
    public String selectAccountByCid(HttpSession session,
                                     Model model) {
        LOGGER.info("excute selectAccountByCid()");
        Customer customer = (Customer) session.getAttribute(BamsConstants.CUSTOMER_SESSION);
        List<Account> accounts = accountService.findselectAccountByCid(customer.getCid());
        model.addAttribute("accounts", accounts);
        return "/selectAllAccount";
    }

    @RequestMapping(value = "/toAccountManage.action")
    public String skipToAccountManage() {
        LOGGER.info("execute skipToAccountManage()");
        return "/manageAccount";
    }

    @RequestMapping(value = "/account/addAccount.action")
    public ModelAndView addAccount(@ModelAttribute Account account,
                                   ModelAndView mv) {
        LOGGER.info("execute addAccount()");
//        LOGGER.info(account.getCustomer().getCid());
        if (account.getCustomer() != null) {
            LOGGER.info(account.getCustomer().getCid());
        } else {
            LOGGER.info("account.getCustomer() = null");
        }
        LOGGER.info(account.getCbalance());
        LOGGER.info(account.getClimit());
        LOGGER.info(account.getCtype());
        accountService.addAccount(account);
        mv.setViewName("redirect:/account/selectAllAccount.action");
        return mv;
    }

    @RequestMapping(value = "/account/updateAccount.action")
    public ModelAndView updateAccount(@ModelAttribute Account account,
                                      ModelAndView mv) {
        LOGGER.info("execute updateAccount()");
        accountService.modifyAccount(account);
        mv.setViewName("redirect:/account/selectAllAccount.action");
        return mv;
    }

    @RequestMapping(value = "/account/removeAccount.action")
    public ModelAndView removeAccount(@RequestParam("aid") String aid,
                                      ModelAndView mv) {
        LOGGER.info("execute removeAccount()");
        LOGGER.info(aid);
        accountService.removeAccountByAid(Integer.parseInt(aid));
        mv.setViewName("redirect:/account/selectAllAccount.action");
        return mv;
    }

    @RequestMapping(value = "/toUpdateAccount.action")
    public String toUpdateAccount() {
        LOGGER.info("toUpdateAccount()");
        return "/updateAccount";
    }
}

















