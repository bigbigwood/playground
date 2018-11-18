package com.example.playground.mybatis_generator.controller;

import com.example.playground.mybatis_generator.entity.Account;
import com.example.playground.mybatis_generator.service.AccountService;
import com.example.playground.mybatis_generator.utils.FilterPageRequest;
import com.example.playground.mybatis_generator.utils.HttpRequestUtils;
import com.example.playground.mybatis_generator.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("/test")
    @ResponseBody
    public String test(Model model, HttpServletRequest request){
        return "hello world";
    }

    @GetMapping("/search/{name}")
    @ResponseBody
    public Account search(@PathVariable String name, HttpServletRequest request){
        return accountService.getAccountByName(name);
    }

    @GetMapping
    @ResponseBody
    public PageResult pageQueryProduct(HttpServletRequest request) {
        FilterPageRequest filterPageRequestDto = HttpRequestUtils.getFilterKeywordPageRequest(request);

        Account account = new Account();
        if (request.getParameter("name") != null) {
            account.setName(request.getParameter("name"));
        }
        filterPageRequestDto.setCondition(account);

        PageResult<Account> pageResult = accountService.pageQueryAccount(filterPageRequestDto);
        return pageResult;
    }

}
