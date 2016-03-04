package EmployeePackage;

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
        return super.toString() + " Monthly Salary: " + getMonthlySalary() + "\n";
    }
}
