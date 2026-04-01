package com.money.transfer.dto;

public class TransferResponse {

    private String message;
    private String fromAccountNumber;
    private String toAccountNumber;
    private double transferredAmount;
    private double fromAccountBalance;
    private double toAccountBalance;

    public TransferResponse() {
    }

    public TransferResponse(String message,
                            String fromAccountNumber,
                            String toAccountNumber,
                            double transferredAmount,
                            double fromAccountBalance,
                            double toAccountBalance) {
        this.message = message;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transferredAmount = transferredAmount;
        this.fromAccountBalance = fromAccountBalance;
        this.toAccountBalance = toAccountBalance;
    }

    public String getMessage() {
        return message;
    }

    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    public String getToAccountNumber() {
        return toAccountNumber;
    }

    public double getTransferredAmount() {
        return transferredAmount;
    }

    public double getFromAccountBalance() {
        return fromAccountBalance;
    }

    public double getToAccountBalance() {
        return toAccountBalance;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFromAccountNumber(String fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public void setToAccountNumber(String toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public void setTransferredAmount(double transferredAmount) {
        this.transferredAmount = transferredAmount;
    }

    public void setFromAccountBalance(double fromAccountBalance) {
        this.fromAccountBalance = fromAccountBalance;
    }

    public void setToAccountBalance(double toAccountBalance) {
        this.toAccountBalance = toAccountBalance;
    }
}