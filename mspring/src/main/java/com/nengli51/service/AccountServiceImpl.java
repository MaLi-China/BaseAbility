package com.nengli51.service;

import com.nengli51.beans.Account;
import com.nengli51.dao.IAccountDao;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    @Override
    public void transfer(Account from, Account to, Float amount) {
        from.setAmount(from.getAmount() - amount);
        to.setAmount(to.getAmount() + amount);
        accountDao.updateAccount(from);
        accountDao.updateAccount(to);
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
