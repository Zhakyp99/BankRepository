package com.example.solidbank;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account")
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Account {
    private AccountType accountType;
    @Id
    @Column(name = "id", length = 255)
    private String id;
    @Column(name = "client_id")
    private String clientID;
    @Column(name = "balance")
    private double balance;
    @Column(name = "withdraw_allowed")
    private boolean withdrawAllowed;
    @Override
    public String toString(){
        return "Account{" +
                "accountType=" + accountType +
                ", id='" + id + '\'' +
                ", clientId='" + clientID + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }

}
