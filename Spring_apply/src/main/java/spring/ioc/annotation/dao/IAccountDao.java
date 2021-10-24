package spring.ioc.annotation.dao;

import spring.ioc.xml.bean.Account;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface IAccountDao {
    void insert(Account account);

    void update(Account account);

    Account findAccount(Integer aid);
}
