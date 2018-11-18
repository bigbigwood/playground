package com.example.playground.mybatis_generator.h2test.repository;

import com.example.playground.mybatis_generator.h2test.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal,Long> {
}