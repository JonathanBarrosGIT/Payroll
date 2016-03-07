import EmployeePackage.Employee;
import EmployeePackage.HourlyEmployee;
import EmployeePackage.CommissionedEmployee;
import EmployeePackage.SalariedEmployee;

import java.util.*;
import java.util.function.Function;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class Payroll implements PayrollConstants{

    private ArrayList <Employee> payrollList;

    Scanner scan = new Scanner(System.in);

    public Payroll() {
        payrollList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        payrollList.add(employee);
    }

    /**
     * @param ID - The employee's ID
     * @return true if the employee is found by its name and false otherwise
     */
    public boolean removeEmployee(int ID){
        for (Employee employee : payrollList){
            if(employee.getId() == ID){
                payrollList.remove(employee);
                return true;
            }
        }
        return false;
    }

    /**
     * @param ID - The employee's ID
     * @param timeCard - The timecard containing the amount of time the employee worked at that day
     */
    public boolean registerTimeCard(int ID, int timeCard){
        for(Employee employee : payrollList){
            if(employee.getId() == ID){
                if(employee instanceof HourlyEmployee){
                    return ((HourlyEmployee) employee).setTimeCardRecords(Calendar.getInstance(), timeCard);
                } else{
                    System.out.println("The employee you entered is not an hourly employee.");
                    return false;
                }
            }
        }
        System.out.println("Employee not found");
        return false;
    }

    public boolean registerSaleResult(int ID, double saleResult){
        for (Employee employee : payrollList){
            if(employee.getId() == ID){
                if(employee instanceof CommissionedEmployee){
                    ((CommissionedEmployee) employee).setSaleResults(Calendar.getInstance(), saleResult);
                    System.out.println("Sale Result registered successfully!");
                    return true;

                } else{
                    System.out.println("The employee you entered is not a commissioned employee");
                    return false;
                }
            }
        }
        System.out.println("Employee not found");
        return false;
    }

    public boolean registerServiceFee(int ID, double serviceFee){
        for(Employee employee : payrollList){
            if(employee.getId() == ID){
                return employee.setServiceFee(serviceFee);
            }
        }
        System.out.println("Employee not found");
        return false;
    }

    public boolean changeEmployeeName(int ID, String name){
        for(Employee employee : payrollList){
            if(employee.getId() == ID){
                employee.setName(name);
                System.out.println("Name changed successfully");
                return true;
            }
        }
        System.out.println("Employee not found!");
        return false;
    }

    public boolean changeEmployeeAddress(int ID, String address){
        for(Employee employee : payrollList){
            if(employee.getId() == ID){
                employee.setAddress(address);
                System.out.println("New address changed successfully");
                return true;
            }
        }
        System.out.println("Employee not found");
        return false;
    }

    public boolean changeLaborUnionSubscription(int ID, boolean subscription){
        for(Employee employee : payrollList){
            if(employee.getId() == ID){
                employee.setLaborUnion(subscription);
                System.out.println("Subscription changed successfully");
                return true;
            }
        }
        System.out.println("Employee not found!");
        return false;
    }

    /* Helper function: It checks if the Labor Union have already assigned this ID to another employee */
    public boolean sameLaborUnionId(int laborUnionID){
        for(Employee employee : payrollList){
            if(employee.getLaborUnionID() == laborUnionID){
                System.out.println("This ID is already taken for another employee.");
                System.out.println("Please, try another ID.");
                return true;
            }
        }
        return false;
    }

    public boolean changeLaborUnionID(int ID, int laborUnionID){
        // First of all, it checks if the entered ID is either already taken or not:
        if(sameLaborUnionId(laborUnionID))
            return false;
        else{
            for(Employee employee : payrollList){
                if(employee.getId() == ID){
                    return employee.setLaborUnionID(laborUnionID);
                }
            }
        }
        System.out.println("Employee not found!");
        return false;
    }

    public boolean changeLaborUnionFee(int ID, double newLaborUnionFee){
        for(Employee employee : payrollList){
            if(employee.getId() == ID)
                return employee.setLaborUnionFee(newLaborUnionFee);
        }
        System.out.println("Employee not found!");
        return false;
    }

    public boolean changePaymentMethod(int ID, int paymentMethod){
        for(Employee employee : payrollList){
            if(employee.getId() == ID) {
                employee.setPaymentMethod(paymentMethod);
                System.out.println("Payment Method changed successfully");
                return true;
            }
        }
        System.out.println("Employee not found!");
        return false;
    }

    /* ------- The following 4 methods were made in order to change the type of employee: ------- */

    public HourlyEmployee changeToHourlyEmployee(Employee currentEmployee)
            throws NumberFormatException,InputMismatchException{

        Function<Employee, HourlyEmployee> toHourlyEmployee = employee1 -> {

            System.out.println("Enter the hourly salary:");
            double hourlySalary = scan.nextDouble();

            HourlyEmployee newHourlyEmployee =
                    new HourlyEmployee(employee1.getName(), employee1.getAddress(), hourlySalary);
            newHourlyEmployee.setID(employee1.getId());

            payrollList.remove(currentEmployee);
            payrollList.add(newHourlyEmployee);

            return newHourlyEmployee;
        };

        if(currentEmployee instanceof HourlyEmployee){
            System.out.println("This employee is already an hourly employee.");
        }else{
            return toHourlyEmployee.apply(currentEmployee);
        }
        return null;
    }

    public SalariedEmployee changeToSalariedEmployee(Employee currentEmployee)
            throws NumberFormatException,InputMismatchException{

        Function<Employee, SalariedEmployee> toSalariedEmployee = employee1 -> {

            System.out.println("Enter the monthly salary:");
            double monthlySalary = scan.nextDouble();

            SalariedEmployee newSalariedEmployee =
                    new SalariedEmployee(employee1.getName(), employee1.getAddress(), monthlySalary);
            newSalariedEmployee.setID(employee1.getId());

            payrollList.remove(currentEmployee);
            payrollList.add(newSalariedEmployee);

            return newSalariedEmployee;
        };

        if(currentEmployee instanceof SalariedEmployee){
            System.out.println("This employee is already a salaried employee.");
        }else{
            return toSalariedEmployee.apply(currentEmployee);
        }
        return null;
    }

    public CommissionedEmployee changeToCommissionedEmployee(Employee currentEmployee)
            throws NumberFormatException,InputMismatchException{

        Function<Employee, CommissionedEmployee> toCommissionedEmployee = employee1 -> {

            System.out.println("Enter the monthly salary:");
            double monthlySalary = scan.nextDouble();
            System.out.println("For Commissioned Employee, please enter the commssion:");

            CommissionedEmployee newCommissionedEmployee = new CommissionedEmployee(employee1.getName(),
                                                                                    employee1.getAddress(),
                                                                                    monthlySalary,
                                                                                    scan.nextDouble());
            newCommissionedEmployee.setID(employee1.getId());

            payrollList.remove(currentEmployee);
            payrollList.add(newCommissionedEmployee);

            return newCommissionedEmployee;
        };

        if(currentEmployee instanceof SalariedEmployee){
            System.out.println("This employee is already a salaried employee.");
        }else{
            return toCommissionedEmployee.apply(currentEmployee);
        }
        return null;
    }

    public boolean changeEmployeeType(int ID, int newEmployeeType){
        for(Employee employee : payrollList){
            if(employee.getId() == ID){
                if(newEmployeeType == HOURLY_EMPLOYEE)
                    return changeToHourlyEmployee(employee) != null;
                else if(newEmployeeType == SALARIED_EMPLOYEE)
                    return changeToSalariedEmployee(employee) != null;
                else if(newEmployeeType == COMMISSIONED_EMPLOYEE)
                    return changeToCommissionedEmployee(employee) != null;
                else{
                    System.out.println("Invalid Command!");
                    return false;
                }
            }
        }
        System.out.println("Employee not found!");
        return false;
    }

    /*--------------------------------------------------------------------------------------------*/

    @Override
    public String toString() {
        return payrollList.toString();
    }
}