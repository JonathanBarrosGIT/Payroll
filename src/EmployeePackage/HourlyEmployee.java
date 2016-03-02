package EmployeePackage;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class HourlyEmployee extends Employee {

    private double hourlySalary;

    public HourlyEmployee(String name, String address, double hourlySalary) {
        super(name, address);
        this.hourlySalary = hourlySalary;
    }

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
        return super.toString() + " Hourly Salary: " + getHourlySalary();
    }
}
