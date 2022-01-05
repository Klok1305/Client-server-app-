package com.example.finaltask.repo;

import com.example.finaltask.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TransactionsRepository extends JpaRepository<Transactions, Double>{
    //@Query (value = "select * from Transactions where customer_id like :id order by amount desc", nativeQuery = true)
    //List<Transactions> findAllByCustomer_idOrderByAmountAmountDesc(Long id);

    @Query (value = "select distinct on (customer_id) * from Transactions order by customer_id, amount desc", nativeQuery = true)
    List<Transactions> returnthing();

    @Query (value = "select customer_id, amount from Transactions where customer_id like :id", nativeQuery = true)
    List<Transactions> ret2(Long id);
}
