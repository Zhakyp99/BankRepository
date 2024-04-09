package com.example.solidbank;

import org.springframework.stereotype.Component;

@Component
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private TransactionDAO transactionDAO;

    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(AccountWithdraw account, double amount) {
        if (account.getBalance() > amount) {
            accountWithdrawService.withdraw(amount, account);

            String transactionDescription = String.format("%.2f$ transferred to %s account", amount, account.getId());
            Transaction transaction = new Transaction();
            transaction.setTransactionId(1L);
            transaction.setTransaction(transactionDescription);
            transactionDAO.save(transaction);
            // Print the details of the last transaction
            Transaction lastTransaction = null;
            for (Transaction t : transactionDAO.findAll()) {
                lastTransaction = t;
            }
            if (lastTransaction != null) {
                System.out.println(lastTransaction.getTransaction());
            }
            //transactionDAO.save(new Transaction(String.format("%.2f$ transferred from %s account", amount, account.getId())));
            //System.out.println(transactionDAO.findAll().get(transactionDAO.findAll().size() - 1).transaction);
        } else {
            System.out.println("You do not have sufficient funds for this operation");
        }
    }
}
