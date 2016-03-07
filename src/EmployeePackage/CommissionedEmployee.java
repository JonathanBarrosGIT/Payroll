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
    HashMap<Integer, Double> saleResults = new HashMap<>();

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

    /*public void setTotalSalary(double saleResult){
        if(saleResult < 0){
            System.out.println("Invalid Entry");
        }else{
            double comissionInDecimal = getCommissionPercentage() / 100;
            totalSalary += saleResult * comissionInDecimal;
        }
    }*/

   public boolean setSaleResults(Calendar date, Double saleResult){
       if(saleResult < 0){
           System.out.println("Invalid Entry. You cannot enter a negative value.");
           return false;
       }else{
           double comissionInDecimal = getCommissionPercentage() / 100;

           saleResults.put(date.get(Calendar.DAY_OF_MONTH), saleResult * comissionInDecimal);
           System.out.println("Sale Result registered successfully!");
           return true;
       }
   }

    @Override
    public String toString() {
        return super.toString() + " Comission: " + getCommissionPercentage() + "\n";
    }
}
