package com.example.seataaccount.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bean.entity.Account;
import com.example.dao.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * TODO
 * @Date: 2022/1/27 16:19
 * @Copyright版权所有 深圳金雅福控股集团有限公司
 * @Author: xzq
 * @Version: 1.0
 */
@Service
public class AccountService extends ServiceImpl<AccountMapper, Account> {

    @Resource
    AccountMapper accountMapper;

    public void deduct(String userId, Long money) {

        Account account = accountMapper.getInfoByUserId(userId);
        if(Objects.isNull(account)){
            throw new RuntimeException();
        }
        account.setMoney(account.getMoney()-money);
        accountMapper.updateById(account);

    }
}
