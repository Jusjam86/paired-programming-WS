package com.pluralsight.models;

public class LeaseContract extends Contract {

    // variables
    private Vehicle vehicle; // vehicle object;
    private double expectedEndingValue = 0.50;
    private double leaseFee = 0.07;

    // constructor
    public LeaseContract(String dateOfContract, String customerName, String customerEmail, boolean vehicleSold,
                         Vehicle vehicle)
    {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.vehicle = vehicle;
    }

    // getters & setters
    public double getExpectedEndingValue() {return expectedEndingValue;}
    public void setExpectedEndingValue(double expectedEndingValue) {this.expectedEndingValue = expectedEndingValue;}

    public double getLeaseFee() {return leaseFee;}
    public void setLeaseFee(double leaseFee) {this.leaseFee = leaseFee;}

    // override methods
    @Override
    public double getTotalPrice()
    {
        return vehicle.getPrice() + (vehicle.getPrice() * expectedEndingValue) + (vehicle.getPrice() * leaseFee);
    }

    @Override
    public double getMonthlyPayment(){

        // new double variable
        double totalPrice = getTotalPrice();
        return totalPrice / 36 * (1 + 0.04);
    }
}
