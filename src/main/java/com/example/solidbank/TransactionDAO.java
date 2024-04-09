package com.example.solidbank;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction,Long> {
    //List<Transaction> getTransactions();
    //void addTransaction(Transaction transaction);
}
