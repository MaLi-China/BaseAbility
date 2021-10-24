package spring.ioc.xml.dao;


import spring.ioc.xml.bean.Account;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface IAccountDao {
    /**
     * @param account 账户
     */
    void updateAccount(Account account);

    Account findAccount(Integer fromAccountId);
}
