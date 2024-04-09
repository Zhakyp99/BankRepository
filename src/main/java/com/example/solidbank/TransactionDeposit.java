package com.example.solidbank;

import org.springframework.stereotype.Component;

@Component
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private TransactionDAO transactionDAO;

    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);

        String transactionDescription = String.format("%.2f$ transferred to %s account",
                amount, account.getId());
        Transaction transaction = new Transaction(String.format("%.2f$ transferred to %s account",
                amount, account.getId()));
        transaction.setTransactionId(1L);
        transaction.setTransaction(transactionDescription);
        transactionDAO.save(transaction);
        // Find the last transaction by iterating through the iterable
        Transaction lastTransaction = null;
        for (Transaction t : transactionDAO.findAll()) {
            lastTransaction = t;
        }
        // Print the details of the last transaction
        if (lastTransaction != null) {
            System.out.println(lastTransaction.getTransaction());
        }

        /*String transactionDescription = String.format("%.2f$ transferred to %s account",
                amount, account.getId());
        Transaction transaction = new Transaction();
        transaction.setTransactionId(1L);
        transaction.setTransaction(transactionDescription);
        transactionDAO.save(transaction);*/


        //transactionDAO.save(new Transaction(String.format("%.2f$ transferred to %s account", amount, account.getId())));

        System.out.println(transactionDAO.findAll().get(transactionDAO.findAll().size() - 1).transaction);
    }
}
