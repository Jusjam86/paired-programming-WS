package com.pluralsight.io;

import com.pluralsight.models.Contract;
import com.pluralsight.models.LeaseContract;
import com.pluralsight.models.SalesContract;
import com.pluralsight.models.Vehicle;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ContractFileManager {

    Vehicle vehicle; //vehicle object;

    public void saveContract(Contract contract)
    {
        try (FileOutputStream fileOutputStream = new FileOutputStream("contracts.csv", true);
             PrintWriter printWriter = new PrintWriter(fileOutputStream))
        {
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract)contract;
                System.out.println("SALE|" + salesContract.getDateOfContract() + "|" + salesContract.getCustomerName()
                        + "|" + salesContract.getCustomerEmail() + "|" + vehicle.getVin() + "|" + vehicle.getYear()
                        + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|"
                        + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|"
                        + salesContract.getSalesTaxAmount() + "|" + salesContract.getRecordingFee() + "|"
                        + salesContract.getProcessingFee() + "|" + salesContract.getTotalPrice() + "|"
                        + salesContract.isFinance() + "|" + salesContract.getMonthlyPayment());
            }
            else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract)contract;
                System.out.println("LEASE|" + leaseContract.getDateOfContract() + "|" + leaseContract.getCustomerName()
                        + "|" + leaseContract.getCustomerEmail() + "|" + vehicle.getVin() + "|" + vehicle.getYear()
                        + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|"
                        + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "|"
                        + leaseContract.getExpectedEndingValue() + "|" + leaseContract.getLeaseFee() + "|"
                        + leaseContract.getTotalPrice() + "|" + leaseContract.getMonthlyPayment());
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
