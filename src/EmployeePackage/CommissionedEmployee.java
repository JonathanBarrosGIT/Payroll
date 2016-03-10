package EmployeePackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class CommissionedEmployee extends Employee {

    private double monthlySalary;
    private double commissionPercentage;
    HashMap<String, Double> saleResults = new HashMap<>();

    public CommissionedEmployee(String name, String address, double monthlySalary, double commissionPercentage) {
        super(name, address);
        this.commissionPercentage = commissionPercentage;
        this.monthlySalary = monthlySalary;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

    public boolean setSaleResults(Double saleResult){
       if(saleResult < 0){
           System.out.println("Invalid Entry. You cannot enter a negative value.");
           return false;
       }else{
           Date date = new Date();
           SimpleDateFormat dateFormatter = new SimpleDateFormat("d/M/yyyy");
           String dateStr = dateFormatter.format(date);

           saleResults.put(dateStr, saleResult * (getCommissionPercentage() / 100));
           Double currentSalary = getScheduledSalary("31/3/2016");
           currentSalary += saleResult * (getCommissionPercentage() / 100);
           setScheduledSalary("31/3/2016",currentSalary);
           System.out.println("Sale Result registered successfully!");
           return true;
       }
    }

    public void setSchedule(){
        for(int i = 0; i < 12; i++){
            setScheduledSalary(daysOfPayment.get(i), monthlySalary);
        }
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
