package EmployeePackage;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class HourlyEmployee extends Employee {

    private double hourlySalary;

    /**
     * This HashMap is going to receive the following:
     * An integer representing the day that the time card is going to be registered
     * Another integer representing the amount of worked hours
     * */
    private HashMap<Integer, Integer> timeCardRecords = new HashMap<>();

    public HourlyEmployee(String name, String address, double hourlySalary) {
        super(name, address);
        this.hourlySalary = hourlySalary;
    }

    public void setTotalSalary(int timeCard) {

        if (timeCard > 8) {
            int overtime = timeCard - 8;
            totalSalary += (hourlySalary * 8 + (hourlySalary * 1.5 * overtime));
        } else {
            totalSalary = hourlySalary * timeCard;
        }
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public boolean setTimeCardRecords(Calendar date, Integer timeCard) {
        if(timeCard < 0){
            System.out.println("Invalid entry. You cannot register a time card with less than 0 hour.");
            return false;
        }else if(timeCardRecords.get(date.get(Calendar.DAY_OF_MONTH)) != null){
            System.out.println("You cannot have duplicated entries!");
            return false;
        }else{
            timeCardRecords.put(date.get(Calendar.DAY_OF_MONTH), timeCard);
            System.out.println(timeCard + " hours of work registered on "
                    + date.get(Calendar.DAY_OF_MONTH) + "/"
                    + (date.get(Calendar.MONTH) + 1) + "/"
                    + date.get(Calendar.YEAR) + " successfully!");
            setTotalSalary(timeCard);
            return true;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n Hourly Salary: " + getHourlySalary() + "\n=====================================\n";
    }
}
