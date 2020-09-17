package com.example.model;

public class AccountInfo {
    private int balance;
    private int credit;
    private int debit;

    public AccountInfo(int balance, int credit, int debit) {
        this.balance = balance;
        this.credit = credit;
        this.debit = debit;
    }

    public AccountInfo() {
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }
}
