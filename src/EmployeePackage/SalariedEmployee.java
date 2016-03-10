package EmployeePackage;

import java.util.HashMap;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class SalariedEmployee extends Employee {

    private double monthlySalary;

    public SalariedEmployee(String name, String address, double monthlySalary) {
        super(name, address);
        this.monthlySalary = monthlySalary;

    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + " \n Monthly Salary: " + getMonthlySalary() + "\n" +
                "=====================================\n";
    }

    public void setSchedule(){
        for(int i = 0; i < 12; i++){
            setScheduledSalary(daysOfPayment.get(i), monthlySalary);
        }
    }

}
