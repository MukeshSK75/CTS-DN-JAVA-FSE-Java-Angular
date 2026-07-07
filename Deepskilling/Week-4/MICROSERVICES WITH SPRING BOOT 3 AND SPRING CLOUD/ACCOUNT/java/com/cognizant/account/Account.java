package com.cognizant.account;

public class Account {
    private String num;
    private String type;
    private double bal;
    public Account(String number, String type, double balance) {
        this.num = number;
        this.type = type;
        this.bal = balance;
    }
    public String getNumber() {
        return num;
    }
    public String getType() {
        return type;
    }
    public double getBalance() {
        return bal;
    }
}