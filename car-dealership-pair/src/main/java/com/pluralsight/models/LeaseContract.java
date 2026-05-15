package com.pluralsight.models;

public abstract class LeaseContract extends Contract {

    private double totalPrice;
    private double monthlyPayment;

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, boolean vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public abstract double getTotalPrice();

    @Override
    public abstract double getMonthlyPayment();
}
