import java.text.DateFormat;
import java.util.*;

/**
 * Created by JonathanBarros on 3/4/16.
 *
 */
public class PaymentSchedule  {

    final String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};

    private String scheduleName;
    private ArrayList<String> daysOfPayment;

    public PaymentSchedule(String scheduleName){
        this.scheduleName = scheduleName;
        daysOfPayment = new ArrayList<>();
        setDaysOfPayment();
    }

    public ArrayList<String> getDaysOfPayment() {
        return daysOfPayment;
    }

    public void addPaymentSchedule(String date){
        daysOfPayment.add(date);

    }

    public void setMonthlyDaysOfPayment(String scheduleName){
        String [] splitScheduleName = scheduleName.split(" ");

        /* Beginning on the first day of 2016 */
        GregorianCalendar calendar = new GregorianCalendar(2016, 0, 1);

        if(splitScheduleName[1].equals("$")){
            for(int i = 0; i < 12; i++){

                switch (month[i]) {
                    //In those months, the last business day is 29
                    case "1":
                    case "2":
                    case "4":
                    case "7":
                        addPaymentSchedule("29" + "/" + month[i] + "/" + "2016");
                        break;
                    //In those months, the last business day is 30
                    case "6":
                    case "9":
                    case "11":
                    case "12":
                        addPaymentSchedule("30" + "/" + month[i] + "/" + "2016");
                        break;
                    //In those months, the last business day is 31
                    case "3":
                    case "5":
                    case "8":
                    case "10":
                        addPaymentSchedule("31" + "/" + month[i] + "/" + "2016");
                        break;
                }
            }

        }else{
            for(int i = 0; i < 12; i++){
                addPaymentSchedule(splitScheduleName[1] + "/" + month[i] + "/" + "2016");
            }
        }
    }

    public void setDaysOfPayment(){

        String[] splitScheduleName = getScheduleName().split(" ");

        if(splitScheduleName[0].equals("monthly")){
            setMonthlyDaysOfPayment(scheduleName);
        }
    }

    public String getScheduleName(){
        return this.scheduleName;
    }

    public void printDaysOfPayment(){
        for(String date : daysOfPayment){
            System.out.println(date);
        }

    }

    /*public void setWeeklyDaysOfPayment(String scheduleName){
        String [] splitScheduleName = scheduleName.split(" ");

        int initialDay = 0;

        switch (splitScheduleName[2]){
            case "monday":
                initialDay = 4;
                break;
            case "tuesday":
                initialDay = 5;
                break;
            case "wednesday":
                initialDay = 6;
                break;
            case "thursday":
                initialDay = 7;
                break;
            case "friday":
                initialDay = 1;
                break;
        }

        if(splitScheduleName[1].equals("1")){
            for(int i = 0; i < 12; i++){

                switch(month[i]){
                    case "1":


                }
            }
        }
    }*/





    //@Override
    /*public String toString(){
        return "\nSchedule Name: " + getScheduleName() + "\n" +
                "Days of Payment: " + "\n"  + printDaysOfPayment();

    }*/
}
