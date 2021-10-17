package com.nengli51.service;

import com.nengli51.beans.Account;

/**
 * 功能说明：构建者
 * 开发人员：@author MaLi
 */
public interface IAccountService {
    void transfer(Account from, Account to, Float amount);
}
