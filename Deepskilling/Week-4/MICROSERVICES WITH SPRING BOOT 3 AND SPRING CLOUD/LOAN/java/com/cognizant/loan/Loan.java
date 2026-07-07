package com.cognizant.loan;

public class Loan {

    private String num;
    private String type;
    private double loan;
    private int emi;
    private int tenure;

    public Loan(String number, String type, double loan, int emi, int tenure) {
        this.num = number;
        this.type = type;
        this.loan = loan;
        this.emi = emi;
        this.tenure = tenure;
    }

    public String getNumber() {
        return num;
    }

    public String getType() {
        return type;
    }

    public double getLoan() {
        return loan;
    }

    public int getEmi() {
        return emi;
    }

    public int getTenure() {
        return tenure;
    }
}