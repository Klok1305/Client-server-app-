package com.example.finaltask.repo;

import com.example.finaltask.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionsRepository extends JpaRepository<Transactions, Long>{
    //List<Transactions> findAllByCustomer_id(Long Customer_id);
}
