package com.example.playground.mybatis_generator.service;

import com.example.playground.mybatis_generator.entity.Account;
import com.example.playground.mybatis_generator.mapper.AccountMapper;
import com.example.playground.mybatis_generator.utils.FilterPageRequest;
import com.example.playground.mybatis_generator.utils.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getAccountByName(String name) {

        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name", name);
        example.setOrderByClause("create_time desc");

        List<Account> accountList = accountMapper.selectByExample(example);
        return accountList.stream().findFirst().orElse(null);
    }

    @Override
    public PageResult<Account> pageQueryAccount(FilterPageRequest<Account> pageRequest) {
        Page<Account> page = PageHelper.startPage(pageRequest.getPageIndex(), pageRequest.getPageSize());
        Example example = new Example(Account.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(pageRequest.getCondition().getName())){
            criteria.andLike("name", pageRequest.getSqlLikeKeyword(pageRequest.getCondition().getName()));
        }

        example.setOrderByClause("create_time desc");
        List<Account> accountList = accountMapper.selectByExample(example);
        PageResult<Account> accountPageResult = new PageResult<>(page.getTotal(),
                page.getPages(), pageRequest.getPageSize(), pageRequest.getPageIndex(), accountList);

        return accountPageResult;
    }
}
