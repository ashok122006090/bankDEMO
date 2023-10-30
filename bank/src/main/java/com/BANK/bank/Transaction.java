package com.BANK.bank;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;
    @ManyToOne
    private Account sourceAccount;
    @ManyToOne
    private Account targetAccount;
    // Other fields and getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Account getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(Account sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public Account getTargetAccount() {
		return targetAccount;
	}
	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}
	
    
}
