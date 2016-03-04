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
    private double serviceFee;

    protected double totalSalary = 0;

    private int paymentMethod;

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
            this.serviceFee = serviceFee;
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

    @Override
    public String toString() {
        return "\n" + "Name: " + getName() + " | ID: " + getId() + " | Adress: " + getAddress() +
                " | Total Salary: " + getTotalSalary() + " | Labor Union Subscription: " + (isLaborUnion() ? "Sim" : "Não");
    }
}
