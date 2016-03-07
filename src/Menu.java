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

    public Menu() {}

    //TODO

    //public PaymentSchedule paymentSchedule = new PaymentSchedule("monthly 4");
    //public PaymentSchedule paymentSchedule1 = new PaymentSchedule("monthly $");
    //public PaymentSchedule paymentSchedule2 = new PaymentSchedule("weekly 1 wednesday");

    Scanner scan = new Scanner(System.in);

    /* Helper function to minimize the duplicated code: */
    private int enterID() throws NumberFormatException, InputMismatchException{
        System.out.println("Enter the ID:");
        int id = Integer.parseInt(scan.next());
        scan.nextLine();
        return id;
    }

    private Payroll addEmployeeMenu(Payroll payroll) {

        boolean addEmployeeLoop = true;
        String name;
        String address;

        while (addEmployeeLoop) {
            try {
                System.out.println("The options are:");
                System.out.println("1 - Add an Hourly Employee");
                System.out.println("2 - Add a Salaried Employee");
                System.out.println("3 - Add a Commissioned Employee");
                System.out.println("99 - Cancel");

                int command = Integer.parseInt(scan.next());
                scan.nextLine();

                if (command == HOURLY_EMPLOYEE || command == SALARIED_EMPLOYEE || command == COMMISSIONED_EMPLOYEE) {
                    System.out.println("Enter the name:");
                    name = scan.nextLine();
                    System.out.println("Enter the address:");
                    address = scan.nextLine();

                    Employee employee = null;

                    switch (command) {
                        case HOURLY_EMPLOYEE:
                            System.out.println("Enter the hourly salary:");
                            employee = new HourlyEmployee(name, address, scan.nextDouble());
                            employee.setPaymentSchedule("weekly 1 friday");
                            System.out.println("The employee " + name + " was added successfully!");
                            break;
                        case SALARIED_EMPLOYEE:
                            System.out.println("Enter the monthly salary:");
                            employee = new SalariedEmployee(name, address, scan.nextDouble());
                            employee.setPaymentSchedule("monthly $");
                            System.out.println("The employee " + name + " was added successfully!");
                            break;
                        case COMMISSIONED_EMPLOYEE:
                            System.out.println("Enter the monthly salary:");
                            double salary = scan.nextDouble();
                            System.out.println("For Commissioned Employee, please enter the commssion:");
                            employee = new CommissionedEmployee(name, address, salary, scan.nextDouble());
                            employee.setPaymentSchedule("weekly 2 friday");
                            System.out.println("The employee " + name + " was added successfully!");
                            break;
                    }
                    addEmployeeLoop = false;
                    payroll.addEmployee(employee);

                } else if (command == CANCEL) {
                    System.out.println("Operation Canceled!");
                    addEmployeeLoop = false;
                } else {
                    System.out.println("Invalid command!");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("The format of the value you entered is invalid. Try the menu below once again:");
                addEmployeeLoop = false;
            }
        }
        return payroll;
    }

    private Payroll removeEmployeeMenu(Payroll payroll) {

        boolean removeLoop = true;

        while (removeLoop) {
            try {
                System.out.println("The options are:");
                System.out.println("1 - Remove employee using his/her ID");
                System.out.println("99 - Cancel");

                int command = Integer.parseInt(scan.next());

                if (command == REMOVE_EMPLOYEE_BY_ID) {
                    System.out.println(payroll.removeEmployee(enterID()) ? "Removed Successfully" : "Employee not found");
                    removeLoop = false;
                } else if (command == CANCEL) {
                    System.out.println("Operation Canceled!");
                    removeLoop = false;
                } else {
                    System.out.println("Invalid Command!");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("The format of the value you entered is invalid. Try the menu below once again:");
                removeLoop = false;
            }
        }
        return payroll;
    }

    private Payroll registerTimecardMenu(Payroll payroll) {
        boolean registerTimeCardloop = true;
        while (registerTimeCardloop) {
            try {
                System.out.println("The options are:");
                System.out.println("1 - Register timecard using employee's ID");
                System.out.println("99 - Cancel");
                int command = Integer.parseInt(scan.next());
                //int command = scan.nextInt();
                scan.nextLine();

                if (command == REGISTER_BY_ID) {
                    int ID = enterID();
                    System.out.println("Enter the amount of hours to be registered:");
                    payroll.registerTimeCard(ID, scan.nextInt());
                    registerTimeCardloop = false;
                } else if (command == CANCEL) {
                    System.out.println("Operation Canceled!");
                    registerTimeCardloop = false;
                } else {
                    System.out.println("Invalid command!");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("The format of the value you entered is invalid. Try the menu below once again:");
                registerTimeCardloop = false;
            }
        }
        return payroll;
    }

    private Payroll registerSaleResultMenu(Payroll payroll) {

        boolean registerSaleResultLoop = true;

        while (registerSaleResultLoop) {
            try {
                System.out.println("The options are:");
                System.out.println("1 - Register sale result using employee's ID");
                System.out.println("99 - Cancel");
                int command = Integer.parseInt(scan.next());
                //int command = scan.nextInt();
                scan.nextLine();

                if (command == REGISTER_BY_ID) {
                    int ID = enterID();
                    System.out.println("Enter the value of the sale result:");
                    payroll.registerSaleResult(ID, scan.nextDouble());
                    registerSaleResultLoop = false;
                } else if (command == CANCEL) {
                    System.out.println("Operation Canceled!");
                    registerSaleResultLoop = false;
                } else {
                    System.out.println("Invalid command!");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("The format of the value you entered is invalid. Try the menu below once again:");
                registerSaleResultLoop = false;
            }
        }
        return payroll;
    }

    private Payroll registerServiceFeeMenu(Payroll payroll) {

        boolean registerServiceFeeLoop = true;

        while (registerServiceFeeLoop) {
            try {
                System.out.println("The options are:");
                System.out.println("1 - Register service fee using employee's ID");
                System.out.println("99 - Cancel");
                int command = Integer.parseInt(scan.next());
                //int command = scan.nextInt();
                scan.nextLine();

                if (command == REGISTER_BY_ID) {
                    int ID = enterID();
                    System.out.println("Enter the value of the service fee:");
                    payroll.registerServiceFee(ID, scan.nextDouble());
                    registerServiceFeeLoop = false;
                } else if (command == CANCEL) {
                    System.out.println("Operation Canceled!");
                    registerServiceFeeLoop = false;
                } else {
                    System.out.println("Invalid command!");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("The format of the value you entered is invalid. Try the menu below once again:");
                registerServiceFeeLoop = false;
            }
        }
        return payroll;
    }

    private Payroll changeEmployeeDetailsMenu(Payroll payroll) {

        boolean changeEmployeeLoop = true;

        while (changeEmployeeLoop) {
            try {
                System.out.println("The options are:");
                System.out.println("1 - Change details using employee's ID");
                System.out.println("99 - Cancel");

                int command = Integer.parseInt(scan.next());
                scan.nextLine();

                if (command == CHANGE_EMPLOYEE_BY_ID) {
                    System.out.println("The options are:");
                    System.out.println("1 - Change Employee's Name");
                    System.out.println("2 - Change Employee's Address");
                    System.out.println("3 - Change Employee's Payment Method");
                    System.out.println("4 - Change Labor Union Subscription");
                    System.out.println("5 - Change Labor Union Identification");
                    System.out.println("6 - Change Labor Union Fee");
                    System.out.println("7 - Change Employee Type");
                    System.out.println("99 - Cancel");

                    int ID;
                    int secondaryCommand = Integer.parseInt(scan.next());
                    scan.nextLine();

                    switch (secondaryCommand) {
                        case CHANGE_NAME:
                            ID = enterID();
                            System.out.println("Enter the new name:");
                            payroll.changeEmployeeName(ID, scan.nextLine());
                            break;
                        case CHANGE_ADDRESS:
                            ID = enterID();
                            System.out.println("Enter the new address");
                            payroll.changeEmployeeAddress(ID, scan.nextLine());
                            break;
                        case CHANGE_PAYMENT_METHOD:
                            ID = enterID();
                            System.out.println("What kind of payment method would you like to register?");
                            System.out.println("1 - A Bank Check delivered by mail");
                            System.out.println("2 - A Bank Check delivered on hands");
                            System.out.println("3 - A Bank Deposit");
                            payroll.changePaymentMethod(ID, scan.nextInt());
                            break;
                        case CHANGE_LABOR_UNION_SUBSCRIPTION:
                            ID = enterID();
                            System.out.println("Do you want to subscribe or unsubscribe the Labor Union?");
                            System.out.println("1 - Subscribe\n2 - Unsubscribe");
                            int subscription = scan.nextInt();
                            payroll.changeLaborUnionSubscription(ID, subscription == 1);
                            break;
                        case CHANGE_LABOR_UNION_ID:
                            ID = enterID();
                            System.out.println("Enter the new Labor Union ID:");
                            payroll.changeLaborUnionID(ID, scan.nextInt());
                            break;
                        case CHANGE_LABOR_UNION_FEE:
                            ID = enterID();
                            System.out.println("Enter the new Labor Union fee value");
                            payroll.changeLaborUnionFee(ID, scan.nextDouble());
                            break;
                        case CHANGE_EMPLOYEE_TYPE:
                            ID = enterID();
                            System.out.println("Enter the new type:");
                            System.out.println("1 - Hourly Employee\n2 - Salaried Employee\n3 - Commissioned Employee");
                            payroll.changeEmployeeType(ID, scan.nextInt());
                            break;
                        case CANCEL:
                            System.out.println("Operation Canceled!");
                            break;
                        default:
                            System.out.println("Invalid Command!");
                            break;

                    }

                    changeEmployeeLoop = false;

                } else if (command == CANCEL) {
                    System.out.println("Operation Canceled!");
                    changeEmployeeLoop = false;
                } else {
                    System.out.println("Invalid Command!");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("The format of the value you entered is invalid. Try the menu below once again:");
                changeEmployeeLoop = false;
            }
        }
        return payroll;
    }

    private Payroll createNewPaymentSchedule(Payroll payroll){

        System.out.println("Some examples of payment schedules:");
        System.out.println("- weekly 1 thursday for payment every week on thursdays");
        System.out.println("- monthly 10 for payment every month in the day 10");
        System.out.println("Now, enter your the payment schedule name:");

        String scheduleName = scan.nextLine();
        payroll.createNewPaymentSchedule(scheduleName);

        return payroll;
    }

    private void runPayroll(Payroll payroll){
        //System.out.println("Enter the day you want to run the payroll:");
        //int day = Integer.parseInt(scan.next());
        //scan.nextLine();

        //payroll.runPayrol(day);
    }

    public void runMenu(Payroll payroll) {

        boolean menuLoop = true;

        while (menuLoop) {
            try {
                System.out.println("Main menu:");
                System.out.println("Enter the number related to the option you want:");
                System.out.println("1 - Add an employee");
                System.out.println("2 - Remove an employee");
                System.out.println("3 - Register a timecard");
                System.out.println("4 - Register a sale result");
                System.out.println("5 - Register a service fee");
                System.out.println("6 - Change the employee details");
                System.out.println("7 - Run payroll");
                System.out.println("8 - Show list of employees");
                System.out.println("9 - Create Payment Schedule");
                System.out.println("10 - Show Available Payment Schedule");
                System.out.println("99 - Quit");
                int command = Integer.parseInt(scan.next());
                scan.nextLine();

                switch (command) {
                    case QUIT:
                        menuLoop = false;
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
                        //TODO Still need to finish this function:
                        //runPayroll(payroll);
                        break;
                    case CREATE_NEW_PAYMENT_SCHEDULE:
                        payroll = createNewPaymentSchedule(payroll);
                        break;
                    case SHOW_PAYMENT_SCHEDULES:
                        payroll.printListOfPaymentSchedules();
                        break;
                    case SHOW_EMPLOYEE_LIST:
                        payroll.printListOfEmployees();
                        break;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("The format of the value you entered is invalid. Try the menu below once again:");
            }
        }
    }
}