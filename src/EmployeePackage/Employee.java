package EmployeePackage;

/**
 * Created by JonathanBarros on 2/29/16.
 *
 */

import java.util.*;

public class Employee {

    private static int count = 0;

    private int id;
    private String name;
    private String address;

    private boolean laborUnion = false;
    private int laborUnionID;
    private double laborUnionFee;
    private Double serviceFee;

    protected double totalSalary = 0;

    private HashMap<String, Double> scheduledSalary = new HashMap<>();

    private String paymentMethod;
    private String paymentScheduleName;
    protected ArrayList<String> daysOfPayment = new ArrayList<>();

    public Employee(String name, String address){
        this.name = name;
        this.address = address;

        // Every time the constructor runs, it increments count.
        count++;

        // Then it sets the employee's ID using count.
        id = count;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public double getLaborUnionFee() {
        return laborUnionFee;
    }

    public double getServiceFee(){
        return serviceFee;
    }

    public int getLaborUnionID() {
        return laborUnionID;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public boolean isLaborUnion() {
        return laborUnion;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLaborUnion(boolean laborUnion) {
        this.laborUnion = laborUnion;
    }

    public boolean setServiceFee(double serviceFee) {
        if(isLaborUnion()){
            Double currentSalary = getScheduledSalary("31/3/2016");
            this.serviceFee = serviceFee;
            setScheduledSalary("31/3/2016", currentSalary - getServiceFee());
            System.out.println("Service fee registered successfully");
            return true;
        }else {
            System.out.println("The employee is not registered in the Labor Union!");
            return false;
        }
    }

    public boolean setLaborUnionID(int laborUnionID) {
        if(isLaborUnion()){
            this.laborUnionID = laborUnionID;
            System.out.println("Labor Union ID set successfully!");
            return true;
        }else{
            System.out.println("The employee is not registered in the Labor Union!");
            return false;
        }
    }

    public boolean setLaborUnionFee(double laborUnionFee) {
        if(isLaborUnion()){
            this.laborUnionFee = laborUnionFee;
            System.out.println("Labor Union Fee registered successfully");
            return true;
        }else{
            System.out.println("The employee is not registered in the Labor Union!");
            return false;
        }
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentScheduleName() {
        return paymentScheduleName;
    }

    public void setPaymentScheduleName(String paymentScheduleName) {
        this.paymentScheduleName = paymentScheduleName;
    }

    public String printLaborUnion(){
        if(isLaborUnion()){
            return "\tSituation: Subscribed\n \tID: " + getLaborUnionID()+
                    "\n\tLabor Union Fee: " + getLaborUnionFee() +
                    "\n\tService Fee: " + getServiceFee();
        }else
            return "\tSituation: Not subscribed";
    }

    @Override
    public String toString() {
        return "\n Name: " + getName() +
                "\n ID: " + getId() +
                "\n Adress: " + getAddress() +
                "\n Labor Union Information:\n" + printLaborUnion() +
                "\n Payment Method: " + (getPaymentMethod() != null ? getPaymentMethod() : "Not yet") +
                "\n Payment Schedule: " + getPaymentScheduleName();
    }

    public void setDaysOfPayment(ArrayList<String> daysOfPayment) {
        this.daysOfPayment = daysOfPayment;
    }

    public Double getScheduledSalary(String date) {
        return scheduledSalary.get(date);
    }

    public void setScheduledSalary(String date, Double salary) {
        this.scheduledSalary.put(date, salary);
    }

}

