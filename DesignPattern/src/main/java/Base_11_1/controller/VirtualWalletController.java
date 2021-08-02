package Base_11_1.controller;

import Base_11_1.service.VirtualWalletService;

import java.math.BigDecimal;
import java.util.List;

/**
 * 功能说明：虚拟钱包的控制层
 * 开发人员：@Author MaLi
 */
public class VirtualWalletController {
    private VirtualWalletService virtualWalletService;

    //获取余额
    public BigDecimal getBalance(Long walletID) {
        return null;
    }

    //转账
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {

    }

    //获取流水
    public List<String> getTransaction(Long walletId) {

        return null;
    }
    //充值

    public void credit(Long walletId, BigDecimal amount) {

    }

    //提现
    public void debit(Long walletId, BigDecimal amount) {

    }

}
