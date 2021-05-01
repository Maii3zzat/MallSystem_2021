/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vdm;
import java.util.Enumeration;

/**
 *
 * @author Cherine.Mohamed
 */


public class Customer {
     private int custID;
     private String name;
     private int age;
     private char gender;
     private FaceMaksStatus facemask;
     private ReservationStatus reservation;
     private WariningType isWarned;

    public Customer(int custID, String name, int age, char gender, FaceMaksStatus facemask, ReservationStatus reservation, WariningType isWarned) {
        this.custID = custID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.facemask = facemask;
        this.reservation = reservation;
        this.isWarned = isWarned;
        
    }


    
    
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public FaceMaksStatus getFacemask() {
        return facemask;
    }

    public void setFacemask(FaceMaksStatus facemask) {
        this.facemask = facemask;
    }

    public ReservationStatus getReservation() {
        return reservation;
    }

    public void setReservation(ReservationStatus reservation) {
        this.reservation = reservation;
    }

    public WariningType getIsWarned() {
        return isWarned;
    }

    public void setIsWarned(WariningType isWarned) {
        this.isWarned = isWarned;
    }
     
     
     
     
    public Customer (String nameValue)
    {
        //super(nameValue);
    }
    
}




