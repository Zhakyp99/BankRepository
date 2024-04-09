package com.example.solidbank;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "transaction_id")
    private Long transactionId;
    @Column(name = "transaction")
    String transaction;
    @Column(name = "account_id")
    private String id;
    public Transaction(String transaction) {
        this.transaction = transaction;
    }


}
