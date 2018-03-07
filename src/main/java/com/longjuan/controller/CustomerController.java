package com.longjuan.controller;

import com.longjuan.domain.Customer;
import com.longjuan.service.BamsService;
import com.longjuan.util.BamsConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class CustomerController {

    private static final Logger LOGGER = Logger.getLogger(CustomerController.class);

    @Autowired
    @Qualifier("bamsService")
    private BamsService bamsService;

    @RequestMapping(value="/login.action", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("cname") String cname,
                              @RequestParam("cpassword") String cpassword,
                              HttpSession session,
                              ModelAndView mv) {
        LOGGER.info("this is enter login()");
        LOGGER.info(cname + "  " + cpassword);
//        调用业务逻辑组件判断用户是否可以登录
        Customer customer = bamsService.login(cname, cpassword);
        LOGGER.info(customer.getCname() + " " + customer.getCaddress());
        if (customer != null) {
            LOGGER.info("enter if of the login");
//            将客户保存到HttpSession当中
            session.setAttribute(BamsConstants.CUSTOMER_SESSION, customer);
//            跳转到main页面
            mv.setViewName("redirect:/main.jsp");
        } else {
            LOGGER.info("enter else of the login");
//            设置登录失败提示信息
            mv.addObject("message", "登录名或密码错误！请重新输入");
//            服务器内部跳转到登录页面
            mv.setViewName("forward:/loginForm");
        }
        return mv;
    }

    /**
     * 退出登录
     * @param session
     * @param mv
     * @return
     */
    @RequestMapping(value = "/logout.action")
    public ModelAndView logout(HttpSession session,
                               ModelAndView mv) {
        session.removeAttribute(BamsConstants.CUSTOMER_SESSION);
        mv.setViewName("redirect:/loginForm.jsp");
        return mv;
    }

    @RequestMapping(value = "/customer/selectAllCustomer.action")
    public String selectAllCustomer(Model model) {
        LOGGER.info("execute selectAllCustomer()");
        List<Customer> customer_list = bamsService.findAllCustomer();
        LOGGER.info(customer_list.toString());
        model.addAttribute("customer_list", customer_list);
        return "/selectAllCustomer";
    }

    @RequestMapping(value = "/customer/selectCustomer.action")
    public String selectCustomer(HttpSession session,
            Model model) {
        LOGGER.info("execute selectCustomer()");
        Customer customer = (Customer) session.getAttribute(BamsConstants.CUSTOMER_SESSION);
        LOGGER.info(customer.getCname());
        model.addAttribute("customer", customer);
        return "/selectCustomer";
    }

    @RequestMapping(value = "/customer/addCustomer.action")
    public ModelAndView addCustomer(@ModelAttribute Customer customer,
                                    ModelAndView mv) {
        LOGGER.info("execute addCustomer()");
        LOGGER.info("addCustomer() --> " + customer.getCname());
        bamsService.addCustomer(customer);
        mv.setViewName("redirect:/customer/selectAllCustomer.action");
        return mv;
    }

    @RequestMapping(value = "/customer/skipToUpdateCustomer.action")
    public String skipToUpdate() {
        LOGGER.info("execute skipToUpdate()");
        return "/updateCustomer";
    }

    @RequestMapping(value = "/customer/updateCustomer.action")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer,
                                       ModelAndView mv) {
        LOGGER.info("execute updateCustomer()");
        LOGGER.info("updateCustomer() --> " + customer.getCid());
        LOGGER.info("updateCustomer() --> " + customer.getCname());
        bamsService.modifyCustomer(customer);
        mv.setViewName("redirect:/customer/selectAllCustomer.action");
        return mv;
    }

    @RequestMapping(value = "/customer/removeCustomer.action")
    public ModelAndView removeCustomer(@RequestParam("cid") String cid,
                                       ModelAndView mv) {
        LOGGER.info("execute removeCustomer()");
        LOGGER.info(cid);
        bamsService.removeCustomerByCid(Integer.parseInt(cid));
        mv.setViewName("redirect:/customer/selectAllCustomer.action");
        return mv;
    }

}
























