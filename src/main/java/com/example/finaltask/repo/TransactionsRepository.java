package com.example.finaltask.repo;

import com.example.finaltask.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TransactionsRepository extends JpaRepository<Transactions, Double>{
    @Query (value = "select * from Transactions where customer_id like :id order by amount desc", nativeQuery = true)
    List<Transactions> findAllByCustomer_idOrderByAmountAmountDesc(Long id);
}
