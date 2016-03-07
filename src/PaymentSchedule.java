import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by JonathanBarros on 3/4/16.
 *
 */
public class PaymentSchedule  {

    private String scheduleName;
    private ArrayList<Integer> daysOfPayment;

    public PaymentSchedule(String scheduleName){
        this.scheduleName = scheduleName;
        daysOfPayment = new ArrayList<>();
        setDaysOfPayment(scheduleName);
    }

    public ArrayList<Integer> getDaysOfPayment() {
        return daysOfPayment;
    }

    public void setDaysOfPayment(String scheduleName){

        String[] splitScheduleName = scheduleName.split(" ");

        if(splitScheduleName[0].equals("monthly")){
            if(splitScheduleName[1].equals("$")){
                daysOfPayment.add(31);
            }
            else{
                daysOfPayment.add(Integer.parseInt(splitScheduleName[1]));
            }
        }
        else if(splitScheduleName[0].equals("weekly")) {
            int day = 1;
            switch (splitScheduleName[2]){
                case "monday":
                    day = 7;
                    break;
                case "tuesday":
                    day = 1;
                    break;
                case "wednesday":
                    day = 2;
                    break;
                case "thursday":
                    day = 3;
                    break;
                case "friday":
                    day = 4;
                    break;
            }

            if(Integer.parseInt(splitScheduleName[1]) == 1){
                int weekAdditional = 0;

                for(int i = (splitScheduleName[2].equals("friday") ? 1 : 0); i <= 4; i++){
                    daysOfPayment.add(day + weekAdditional);
                    weekAdditional += 7;
                }

            }else if(Integer.parseInt(splitScheduleName[1]) == 2){
                daysOfPayment.add(day);
                daysOfPayment.add(day + 14);
            }
        }
    }

    public String getScheduleName(){
        return this.scheduleName;
    }

    @Override
    public String toString(){
        return "\nSchedule Name: " + getScheduleName() + "\n" +
                "Days of Payment: " + daysOfPayment;

    }
}
