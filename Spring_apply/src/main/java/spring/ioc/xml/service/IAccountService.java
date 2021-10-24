package spring.ioc.xml.service;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface IAccountService {
    void transfer(Integer fromAccountId, Integer toAccountId, Float amount);
}
