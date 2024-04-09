package com.example.solidbank;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class SavingAccount extends AccountWithdraw{

    public SavingAccount(AccountType accountType, String id, String clientID, double balance) {
        super(accountType, id, clientID, balance);
    }

}
