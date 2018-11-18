package com.example.playground.mybatis_generator.service;

import com.example.playground.mybatis_generator.entity.Account;
import com.example.playground.mybatis_generator.utils.FilterPageRequest;
import com.example.playground.mybatis_generator.utils.PageResult;

public interface AccountService {
    Account getAccountByName(String name);
    PageResult<Account> pageQueryAccount(FilterPageRequest<Account> pageRequest);
}
