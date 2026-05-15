package com.pluralsight.models;

public abstract class SalesContract extends Contract {

    // variables
    private Vehicle vehicle; //vehicle object
    private double totalPrice;
    private double monthlyPayment;
    private double salesTaxAmount = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean finance; // y/n
    private boolean isMonthlyPaymentFinanced;

    // constructor
    public SalesContract(String dateOfContract, String customerName, String customerEmail, boolean vehicleSold,
                         double totalPrice, double monthlyPayment, double salesTaxAmount, double recordingFee,
                         double processingFee, Vehicle vehicle, boolean finance, boolean isMonthlyPaymentFinanced)
    {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.vehicle = vehicle; // vehicle object
        this.finance = finance;
        this.isMonthlyPaymentFinanced = isMonthlyPaymentFinanced;
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

    public boolean isMonthlyPaymentFinanced()
    {
        return isMonthlyPaymentFinanced;
    }

    public void setMonthlyPaymentFinanced(boolean monthlyPaymentFinanced) {isMonthlyPaymentFinanced = monthlyPaymentFinanced;}

    @Override
    public double getTotalPrice()
    {
        return totalPrice;
    };

    @Override
    public abstract double getMonthlyPayment();
}
