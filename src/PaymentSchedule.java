import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

    public void setDaysOfPayment(String scheduleName){

        String[] splitScheduleName = scheduleName.split(" ");
        Calendar marchCalendar = new GregorianCalendar(2016, 3, 1);

        if(splitScheduleName[0].equals("mensal")){
            if(splitScheduleName[1].equals("$")){
                daysOfPayment.add(31);
            }
            else{
                daysOfPayment.add(Integer.parseInt(splitScheduleName[1]));
            }
        }
        else if(splitScheduleName[0].equals("semanal")) {
            int day = 1;
            switch (splitScheduleName[2]){
                case "segunda":
                    day = 7;
                    break;
                case "terca":
                    day = 1;
                    break;
                case "quarta":
                    day = 2;
                    break;
                case "quinta":
                    day = 3;
                    break;
                case "sexta":
                    day = 4;
                    break;
            }

            if(Integer.parseInt(splitScheduleName[1]) == 1){
                int weekAdditional = 0;
                for(int i = 0; i < 4; i++){
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
        return "Schedule Name: " + getScheduleName() + "\n" +
                "Days of Payment: " + daysOfPayment;

    }
}
