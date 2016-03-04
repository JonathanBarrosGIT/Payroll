package EmployeePackage;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class CommissionedEmployee extends Employee {

    private double monthlySalary;
    private double commission;

    public CommissionedEmployee(String name, String address, double monthlySalary, double commission) {
        super(name, address);
        this.commission = commission;
        this.monthlySalary = monthlySalary;
    }

    public double getCommission() {
        return commission;
    }

    @Override
    public String toString() {
        return super.toString() + " Comission: " + getCommission() + "\n";
    }

    public void setTotalSalary(double saleResult){
        if(saleResult < 0){
            System.out.println("Invalid Entry");
        }else{
            double comissionInDecimal = getCommission() / 100;
            totalSalary += saleResult * comissionInDecimal;
        }
    }
}
