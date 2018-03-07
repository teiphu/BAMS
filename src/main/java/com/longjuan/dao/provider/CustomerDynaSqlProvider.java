package com.longjuan.dao.provider;

import com.longjuan.domain.Customer;
import com.longjuan.util.BamsConstants;
import org.apache.ibatis.jdbc.SQL;
import org.apache.log4j.Logger;


public class CustomerDynaSqlProvider {

    private static final Logger LOGGER = Logger.getLogger(CustomerDynaSqlProvider.class);

    public String insertCustomer(final Customer customer) {
        LOGGER.info("execute insertCustomer()");
        LOGGER.info(customer.getCname() + " " + customer.getCpassword());
        return new SQL() {
            {
                INSERT_INTO(BamsConstants.CUSTOMERTABLE);
                if (customer.getCname() != null && !customer.getCname().equals("")) {
                    VALUES("cname", "#{cname}");
                }
                if (customer.getCpassword() != null && !customer.getCpassword().equals("")) {
                    VALUES("cpassword", "#{cpassword}");
                }
                if (customer.getCphone() != null && !customer.getCphone().equals("")) {
                    VALUES("cphone", "#{cphone}");
                }
                if (customer.getCemail() != null && !customer.getCemail().equals("")) {
                    VALUES("cemail", "#{cemail}");
                }
                if (customer.getCaddress() != null && !customer.getCaddress().equals("")) {
                    VALUES("caddress", "#{caddress}");
                }
            }
        }.toString();
    }

    public String updateCustomer(final Customer customer) {
        LOGGER.info("execute updateCustomer()");
        LOGGER.info(customer.getCid());
        return new SQL() {
            {
                UPDATE(BamsConstants.CUSTOMERTABLE);
                if (customer.getCname() != null && !customer.getCname().equals("")) {
                    SET(" cname = #{cname} ");
                }
                if (customer.getCpassword() != null && !customer.getCpassword().equals("")) {
                    SET(" cpassword = #{cpassword} ");
                }
                if (customer.getCphone() != null && !customer.getCphone().equals("")) {
                    SET(" cphone = #{cphone} ");
                }
                if (customer.getCemail() != null && !customer.getCemail().equals("")) {
                    SET(" cemail = #{cemail} ");
                }
                if (customer.getCaddress() != null && !customer.getCaddress().equals("")) {
                    SET(" caddress = #{caddress} ");
                }
                WHERE(" cid = #{cid} ");
            }
        }.toString();
    }
}
