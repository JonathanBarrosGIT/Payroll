package EmployeePackage;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class CommissionedEmployee extends Employee {

    private double monthlySalary;
    private double commissionPercentage;
    HashMap<Calendar, Double> saleResults = new HashMap<>();

    public CommissionedEmployee(String name, String address, double monthlySalary, double commissionPercentage) {
        super(name, address);
        this.commissionPercentage = commissionPercentage;
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public boolean setSaleResults(Calendar date, Double saleResult){
       if(saleResult < 0){
           System.out.println("Invalid Entry. You cannot enter a negative value.");
           return false;
       }else{

           saleResults.put(date, saleResult * (getCommissionPercentage() / 100));
           //totalSalary += saleResult * comissionInDecimal;
           System.out.println("Sale Result registered successfully!");
           return true;
       }
   }

    public HashMap<Calendar, Double> getSaleResults() {
        return saleResults;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n Comission Percentage: " +
                getCommissionPercentage() + "%" +
                "\n" +
                "=====================================\n";
    }
}
