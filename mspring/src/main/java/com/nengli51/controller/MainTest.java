package com.nengli51.controller;

import com.nengli51.beans.Account;
import com.nengli51.facotry.BeanFactory;
import com.nengli51.facotry.SpringContext;
import com.nengli51.service.IAccountService;
import org.junit.Test;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MainTest {

    private IAccountService accountService;

    @Test
    public void doAction() {
        SpringContext context = BeanFactory.getContext("beans.xml");
        accountService = (IAccountService) context.getBean("service");
        Account from = new Account();
        Account to = new Account();
        from.setId(1);
        to.setId(2);
        accountService.transfer(from, to, 100F);
    }

    public IAccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
