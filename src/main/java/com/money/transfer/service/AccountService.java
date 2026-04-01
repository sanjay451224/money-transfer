package com.money.transfer.service;

import com.money.transfer.dto.TransferRequest;
import com.money.transfer.dto.TransferResponse;
import com.money.transfer.exception.ResourceNotFoundException;
import com.money.transfer.model.Account;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {
    
    private final Map<String, Account> accountStore = new HashMap<>();

    @PostConstruct
    public void inMemoryData() {
        accountStore.put("ACC1001", new Account(1L, "ACC1001", "Ajay Prajapat", 5000.00));
        accountStore.put("ACC1002", new Account(2L, "ACC1002", "Ravi Sharma", 3000.00));
        accountStore.put("ACC1003", new Account(3L, "ACC1003", "Priya Verma", 7000.00));
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accountStore.values());
    }

    public Account getAccountByNumber(String accountNumber) {
        Account account = accountStore.get(accountNumber);
        if (account == null) {
            throw new ResourceNotFoundException("Account not found: " + accountNumber);
        }
        return account;
    }

    public synchronized TransferResponse transfer(TransferRequest request) {

        if (request.getFromAccountNumber() == null || request.getFromAccountNumber().isBlank()) {
            throw new IllegalArgumentException("From account number is required");
        }

        if (request.getToAccountNumber() == null || request.getToAccountNumber().isBlank()) {
            throw new IllegalArgumentException("To account number is required");
        }

        if (request.getFromAccountNumber().equals(request.getToAccountNumber())) {
            throw new IllegalArgumentException("From and To account cannot be same");
        }

        if (request.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        Account fromAccount = accountStore.get(request.getFromAccountNumber());
        if (fromAccount == null) {
            throw new ResourceNotFoundException("Sender account not found: " + request.getFromAccountNumber());
        }

        Account toAccount = accountStore.get(request.getToAccountNumber());
        if (toAccount == null) {
            throw new ResourceNotFoundException("Receiver account not found: " + request.getToAccountNumber());
        }

        if (fromAccount.getBalance() < request.getAmount()) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        toAccount.setBalance(toAccount.getBalance() + request.getAmount());

        return new TransferResponse(
                "Transfer successful",
                fromAccount.getAccountNumber(),
                toAccount.getAccountNumber(),
                request.getAmount(),
                fromAccount.getBalance(),
                toAccount.getBalance()
        );
    }
}