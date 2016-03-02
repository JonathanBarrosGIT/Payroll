import java.util.Scanner;

/**
 * Created by JonathanBarros on 3/1/16.
 *
 */
public class Main {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        Menu menu = new Menu();
        Payroll payroll = new Payroll();

        System.out.println("Welcome to the Payroll System:");
        System.out.println("If you would like to proceed to the main menu, please type: Start");
        System.out.println("Otherwise, type: Cancel");

        String option = scan.nextLine();

        while(true){
            if(option.toLowerCase().equals("start")){
                menu.runMenu(payroll);
                System.out.println("Thanks for using our system.");
                System.exit(0);
            }else if(option.equals("cancel")){

                System.exit(0);
            }
            option = scan.nextLine();
        }
    }
}
