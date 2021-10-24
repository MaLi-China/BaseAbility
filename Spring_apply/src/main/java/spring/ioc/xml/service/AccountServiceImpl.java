package spring.ioc.xml.service;

import spring.ioc.xml.bean.Account;
import spring.ioc.xml.dao.IAccountDao;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(Integer fromAccountId, Integer toAccountId, Float amount) {
        Account fromAccount = accountDao.findAccount(fromAccountId);
        Account toAccount = accountDao.findAccount(toAccountId);
        fromAccount.setAmount(fromAccount.getAmount() - amount);
        toAccount.setAmount(toAccount.getAmount() + amount);
        accountDao.updateAccount(fromAccount);
        int i = 1 / 0;
        accountDao.updateAccount(toAccount);
    }
}
