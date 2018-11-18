package com.example.playground.mybatis_generator.h2test.controller;

import com.example.playground.mybatis_generator.h2test.repository.JournalRepository;
import com.example.playground.mybatis_generator.h2test.domain.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.text.ParseException;

@Controller
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    JournalRepository repo;

    @GetMapping("/")
    @ResponseBody
    public String index(Model model) {
        model.addAttribute("journal", repo.findAll());
        return "ok";
    }

    @GetMapping("/test")
    @ResponseBody
    @Transactional
    public String add() throws ParseException {

        for (Integer i = 0; i < 10000000; i++) {
            Journal journal = new Journal(i.toString(), "Today I will learn Spring Boot", "01/01/2016");
            repo.save(journal);
            System.out.println(journal.getTitle());
        }

        return "add journal successfully";
    }
}