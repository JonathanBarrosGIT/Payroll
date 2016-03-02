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

    protected double totalSalary = 0;

    private boolean laborUnion = false;
    private String laborUnionID;
    private double laborUnionFee;
    private double serviceFee;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " ID: " + getId() + " Adress: " + getAddress();
    }


    public boolean isLaborUnion() {
        return laborUnion;
    }

    public void setLaborUnion(boolean laborUnion) {
        this.laborUnion = laborUnion;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }
}
