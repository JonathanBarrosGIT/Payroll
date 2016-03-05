package EmployeePackage;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class HourlyEmployee extends Employee {

    private double hourlySalary;

    /**
     * This HashMap is going to receive the following:
     * */
    private HashMap<Integer, Integer> timeCardRegistrations = new HashMap<>();

    public HourlyEmployee(String name, String address, double hourlySalary) {
        super(name, address);
        this.hourlySalary = hourlySalary;
    }

    //TODO See what to do with this method
    public void setTotalSalary(int timeCard) {

        if(timeCard < 0){
            System.out.println("Invalid entry");
        }else {
            if (timeCard > 8) {
                int overtime = timeCard - 8;
                totalSalary += (hourlySalary * 8 + (hourlySalary * 1.5 * overtime));
            } else {
                totalSalary = hourlySalary * timeCard;
            }
        }
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + " | Hourly Salary: " + getHourlySalary() + "\n";
    }

    public boolean setTimeCardRegistrations(Calendar date, int timeCard) {

        if(timeCard < 0){
            System.out.println("Invalid entry. You cannot register a time card with less than 0 hour.");
            return false;
        }else if(timeCardRegistrations.get(date.get(Calendar.DAY_OF_MONTH)) != null){
            System.out.println("You cannot have duplicated entries!");
            return false;
        }else{
            timeCardRegistrations.put(date.get(Calendar.DAY_OF_MONTH), timeCard);
            System.out.println(timeCard + " hours of work registered on "
                    + date.get(Calendar.DAY_OF_MONTH) + "/"
                    + (date.get(Calendar.MONTH) + 1) + "/"
                    + date.get(Calendar.YEAR) + " successfully!");
            return true;
        }
    }
}
