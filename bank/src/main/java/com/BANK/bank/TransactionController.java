package com.BANK.bank;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
 
    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(
        @RequestParam Long sourceAccountId,
        @RequestParam Long targetAccountId,
        @RequestParam BigDecimal amount
    ) {
        transactionService.transferMoney(sourceAccountId, targetAccountId, amount);
        return ResponseEntity.ok("Money transferred successfully.");
    }
}
