package com.pluralsight.models;

public class SalesContract extends Contract {

    // variables
    private Vehicle vehicle; //vehicle object;
    private double salesTaxAmount = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean finance; // y/n

    // constructor
    public SalesContract(String dateOfContract, String customerName, String customerEmail,
                         boolean vehicleSold, Vehicle vehicle, boolean finance)
    {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.vehicle = vehicle;
        this.finance = finance;
    }

    // getters & setters
    public double getSalesTaxAmount() {return salesTaxAmount;}

    public void setSalesTaxAmount(double salesTaxAmount) {this.salesTaxAmount = salesTaxAmount;}

    public double getRecordingFee() {return recordingFee;}

    public void setRecordingFee(double recordingFee) {this.recordingFee = recordingFee;}

    public double getProcessingFee()
    {
        if (vehicle.getPrice() < 10000){
            return 295;
        }
        if (vehicle.getPrice() > 10000){
            return 495;
        }
        return 0.00;
    }

    public void setProcessingFee(double processingFee) {this.processingFee = processingFee;}

    public boolean isFinance() {return finance;}

    public void setFinance(boolean finance) {this.finance = finance;}

    // override methods

    @Override
    public double getTotalPrice()
    {
        return vehicle.getPrice() + (vehicle.getPrice() * salesTaxAmount) + recordingFee + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment()
    {
        // for if user doesn't want to finance vehicle
        if (!finance) {return 0;}

        // calculations for the monthly payment using the vehicle's total price
        double totalPrice = getTotalPrice();

        if (totalPrice >= 10000)
        {
            // new double variable
            return totalPrice / 48 * (1 + 0.0425);
        }
        else
        {
            return totalPrice / 24 * (1 + 0.0525);
        }

    }
}
