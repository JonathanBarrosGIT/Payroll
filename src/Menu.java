import EmployeePackage.CommissionedEmployee;
import EmployeePackage.Employee;
import EmployeePackage.HourlyEmployee;
import EmployeePackage.SalariedEmployee;

import java.util.*;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */
public class Menu implements PayrollConstants {

    public Menu(){}

    Scanner scan = new Scanner(System.in);

    //Helper functions to minimize the duplicated code:
    private int enterID(){
        System.out.println("Enter the ID:");
        int id = scan.nextInt();
        scan.nextLine();
        return id;
    }

    private String enterName(){
        System.out.println("Enter the name:");
        return scan.nextLine();
    }
    /*-----------------------------------------------*/

    private Payroll addEmployeeMenu(Payroll payroll){

        String name;
        String address;

        System.out.println("The options are:");
        System.out.println("1 - Add an Hourly Employee");
        System.out.println("2 - Add a Salaried Employee");
        System.out.println("3 - Add a Commissioned Employee");
        System.out.println("99 - Cancel");

        int option = scan.nextInt();
        scan.nextLine();

        if(option == ADD_HOURLY_EMPLOYEE || option == ADD_SALARIED_EMPLOYEE || option == ADD_COMMISSIONED_EMPLOYEE) {
            System.out.println("Enter the name:");
            name = scan.nextLine();
            System.out.println("Enter the address:");
            address = scan.nextLine();
            System.out.println("Enter the salary (Hourly or Monthly)");
            double salary = scan.nextDouble();
            Employee employee = null;

            switch (option) {
                case ADD_HOURLY_EMPLOYEE:
                    employee = new HourlyEmployee(name, address, salary);
                    break;
                case ADD_SALARIED_EMPLOYEE:
                    employee = new SalariedEmployee(name, address, salary);
                    break;
                case ADD_COMMISSIONED_EMPLOYEE:
                    System.out.println("For Commissioned Employee, please enter the commssion:");
                    double comission = scan.nextDouble();
                    employee = new CommissionedEmployee(name, address, salary, comission);
                    break;
            }
            payroll.addEmployee(employee);
        }else if(option == CANCEL){
            System.out.println("Operation Canceled!");
        }else{
            System.out.println("Invalid command!");
        }
        return payroll;
    }

    private Payroll removeEmployeeMenu(Payroll payroll){
        System.out.println("The options are:");
        System.out.println("1 - Remove employee using ID");
        System.out.println("2 - Remove employee using name");
        System.out.println("99 - Cancel");

        int command = scan.nextInt();
        scan.nextLine();

        if (command == REMOVE_EMPLOYEE_BY_ID){
            System.out.println(payroll.removeEmployee(enterID()) ? "Removed Successfully" : "Employee not found");
        }else if(command == REMOVE_EMPLOYEE_BY_NAME){
            System.out.println(payroll.removeEmployee(enterName()) ? "Removed Successfully" : "Employee not found");
        }else if(command == CANCEL){
            System.out.println("Operation Canceled!");
        }else{
            System.out.println("Invalid Command!");
        }
        return payroll;
    }

    private Payroll registerTimecardMenu(Payroll payroll){

        System.out.println("The options are:");
        System.out.println("1 - Register timecard using ID");
        System.out.println("2 - Register timecard using name");
        System.out.println("99 - Cancel");

        int command = scan.nextInt();
        scan.nextLine();

        if(command == REGISTER_BY_ID){
            int ID = enterID();
            System.out.println("Enter the amount of hours to be registered:");
            int timeCard = scan.nextInt();
            payroll.registerTimeCard(ID, timeCard);
        }else if(command == REGISTER_BY_NAME){
            System.out.println("Enter the amount of hours to be registered:");
            int timeCard = scan.nextInt();
            payroll.registerTimeCard(enterName(), timeCard);
        }else if(command == CANCEL){
            System.out.println("Operation Canceled!");
        }else{
            System.out.println("Invalid command!");
        }
        return payroll;
    }

    private Payroll registerSaleResultMenu(Payroll payroll){
        System.out.println("The options are:");
        System.out.println("1 - Register sale result using ID");
        System.out.println("2 - Register sale result using name");
        System.out.println("99 - Cancel");

        int command = scan.nextInt();
        scan.nextLine();

        if(command == REGISTER_BY_ID){
            int ID = enterID();
            System.out.println("Enter the value of the sale result:");
            double saleResult = scan.nextDouble();
            payroll.registerSaleResult(ID, saleResult);
        }else if(command == REGISTER_BY_NAME){
            System.out.println("Enter the value of the sale result:");
            double saleResult = scan.nextDouble();
            payroll.registerSaleResult(enterName(), saleResult);
        }else if(command == CANCEL){
            System.out.println("Operation Canceled!");
        }else{
            System.out.println("Invalid command!");
        }

        return payroll;
    }

    private Payroll registerServiceFeeMenu(Payroll payroll){

        System.out.println("The options are:");
        System.out.println("1 - Register service fee using ID");
        System.out.println("2 - Register service fee using name");
        System.out.println("99 - Cancel");

        int command = scan.nextInt();
        scan.nextLine();

        if(command == REGISTER_BY_ID){
            int ID = enterID();
            System.out.println("Enter the value of the service fee:");
            double serviceFee = scan.nextDouble();
            payroll.registerServiceFee(ID, serviceFee);
        }else if(command == REGISTER_BY_NAME){
            System.out.println("Enter the value of the service fee:");
            double serviceFee = scan.nextDouble();
            payroll.registerServiceFee(enterName(), serviceFee);
        }else if(command == CANCEL){
            System.out.println("Operation Canceled!");
        }else{
            System.out.println("Invalid command!");
        }
        return payroll;
    }

    private Payroll changeEmployeeDetailsMenu(Payroll payroll){
        System.out.println("The options are:");
        System.out.println("1 - Change details using ID");
        System.out.println("2 - Change details using name");
        System.out.println("99 - Cancel");

        int command = scan.nextInt();
        scan.nextLine();

        if(command == CHANGE_EMPLOYEE_BY_ID){
            System.out.println("The options are:");
            System.out.println("1 - Change employee's name");
            System.out.println("2 - Change employee's address");
            System.out.println("3 - Change employee's payment method");
            System.out.println("4 - Change Labor Union subscription");
            System.out.println("5 - Change Labor Union identification");
            System.out.println("6 - Change Labor Union fee");
            System.out.println("99 - Cancel");

            int secondaryCommand = scan.nextInt();
            scan.nextLine();
            int ID;

            switch (secondaryCommand){
                case CHANGE_NAME:
                    ID = enterID();
                    System.out.println("Enter the new name:");
                    String name = scan.nextLine();
                    payroll.changeEmployeeName(ID, name);
                    break;
                case CHANGE_ADDRESS:
                    ID = enterID();
                    System.out.println("Enter the new address");
                    String address = scan.nextLine();
                    payroll.changeEmployeeAddress(ID, address);
                    break;
                case CHANGE_LABOR_UNION_SUBSCRIPTION:
                    ID = enterID();
                    System.out.println("Do you want to subscribe or unsubscribe the Labor Union?");
                    System.out.println("1 - Subscribe\n2 - Unsubscribe");
                    int subscription = scan.nextInt();
                    payroll.changeLaborUnionSubscription(ID, subscription == 1);
                    break;
                case CANCEL:
                    System.out.println("Operation Canceled!");
                    break;
                default:
                    System.out.println("Invalid Command!");
                    break;
            }
        }else if(command == CANCEL){
            System.out.println("Operation Canceled!");
        }else{
            System.out.println("Invalid Command!");
        }

        return payroll;
    }

    public void runMenu(Payroll payroll){

        boolean loop = true;

        while(loop){
            System.out.println("Main menu:");
            System.out.println("Enter the number related to the option you want:");
            System.out.println("1 - Add an employee");
            System.out.println("2 - Remove an employee");
            System.out.println("3 - Register a timecard");
            System.out.println("4 - Register a sale result");
            System.out.println("5 - Register a service fee");
            System.out.println("6 - Change the employee details");
            //System.out.println("7 - Run payroll for today");
            System.out.println("8 - Show list of employees");
            System.out.println("99 - Quit");

            int command = scan.nextInt();

            switch (command){
                case QUIT:
                    loop = false;
                    break;
                case ADD_EMPLOYEE:
                    payroll = addEmployeeMenu(payroll);
                    break;
                case REMOVE_EMPLOYEE:
                    payroll = removeEmployeeMenu(payroll);
                    break;
                case REGISTER_CARDTIME:
                    payroll = registerTimecardMenu(payroll);
                    break;
                case REGISTER_SALE_RESULT:
                    payroll = registerSaleResultMenu(payroll);
                    break;
                case REGISTER_SERVICE_FEE:
                    payroll = registerServiceFeeMenu(payroll);
                    break;
                case CHANGE_EMPLOYEE_DETAILS:
                    payroll = changeEmployeeDetailsMenu(payroll);
                    break;
                case RUN_PAYROLL:
                    break;
                case SHOW_EMPLOYEE_LIST:
                    System.out.println(payroll.toString());
                    break;
            }
        }
    }
}
