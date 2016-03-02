import EmployeePackage.Employee;
import EmployeePackage.HourlyEmployee;
import EmployeePackage.CommissionedEmployee;

import java.util.ArrayList;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class Payroll {

    private ArrayList <Employee> payrollList;

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
     * @param name - The employee's name
     * @return true if the employee is found by its name and false otherwise
     */
    public boolean removeEmployee(String name){
        for(Employee employee : payrollList){
            if(employee.getName().equals(name)){
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
                    ((HourlyEmployee) employee).setTotalSalary(timeCard);
                    System.out.println("Timecard registered successfully!");
                    return true;
                } else{
                    System.out.println("The employee you entered is not an hourly employee.");
                    return false;
                }
            }
        }
        System.out.println("Employee not found");
        return false;
    }

    /**
     * @param name - The employee's name
     * @param timeCard - The timecard containing the amount of time the employee worked at that day
     */
    public boolean registerTimeCard(String name, int timeCard){
        for(Employee employee : payrollList){
            if(employee.getName().equals(name)){
                if(employee instanceof HourlyEmployee){
                    ((HourlyEmployee) employee).setTotalSalary(timeCard);
                    System.out.println("Timecard registered successfully!");
                    return true;
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
                    ((CommissionedEmployee) employee).setTotalSalary(saleResult);
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

    public boolean registerSaleResult(String name, double saleResult){
        for (Employee employee : payrollList){
            if(employee.getName().equals(name)){
                if(employee instanceof CommissionedEmployee){
                    ((CommissionedEmployee) employee).setTotalSalary(saleResult);
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
                if(employee.isLaborUnion()){
                    System.out.println("Service fee registered successfuly");
                    employee.setServiceFee(serviceFee);
                    return true;
                }else{
                    System.out.println("The employee is not registered in the Labor Union!");
                    return false;
                }
            }
        }
        System.out.println("Employee not found");
        return false;
    }

    public boolean registerServiceFee(String name, double serviceFee){
        for(Employee employee : payrollList){
            if(employee.getName().equals(name)){
                if(employee.isLaborUnion()){
                    System.out.println("Service fee registered successfuly");
                    employee.setServiceFee(serviceFee);
                    return true;
                }else{
                    System.out.println("The employee is not registered in the Labor Union!");
                    return false;
                }
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

    @Override
    public String toString() {
        return payrollList.toString();
    }
}
