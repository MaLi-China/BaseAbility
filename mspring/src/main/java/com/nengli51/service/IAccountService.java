package com.nengli51.service;

import com.nengli51.beans.Account;

/**
 * ����˵����
 * ������Ա��@author MaLi
 */
public interface IAccountService {
    void transfer(Account from, Account to, Float amount);
}
