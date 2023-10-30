package com.BANK.bank;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service
public class TransactionService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public void transferMoney(Long sourceAccountId, Long targetAccountId, BigDecimal amount) {
        // Fetch the source and target accounts from the repository
        Account sourceAccount = accountRepository.findById(sourceAccountId).orElse(null);
        Account targetAccount = accountRepository.findById(targetAccountId).orElse(null);

        if (sourceAccount == null || targetAccount == null) {
            throw new AccountNotFoundException("One or more accounts not found.");
        }

        // Validate if the sourceAccount has sufficient balance
        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance in the source account.");
        }

        // Update account balances
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        targetAccount.setBalance(targetAccount.getBalance().add(amount));

        // Create a transaction record
        Transaction transaction = new Transaction();
        transaction.setDescription("Money transfer");
        transaction.setAmount(amount);
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);

        
        // Save changes to the database
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
        transactionRepository.save(transaction);
    }
}
