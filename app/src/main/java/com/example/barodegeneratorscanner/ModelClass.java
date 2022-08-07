package com.example.barodegeneratorscanner;

public class ModelClass {
    String name,lastname,email,pass,conpass;
    String itemName,itemWeight,itemContainer,time;

    public ModelClass() {
    }

    public ModelClass(String itemName, String itemWeight, String itemContainer, String time) {
        this.itemName = itemName;
        this.itemWeight = itemWeight;
        this.itemContainer = itemContainer;
        this.time = time;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(String itemWeight) {
        this.itemWeight = itemWeight;
    }

    public String getItemContainer() {
        return itemContainer;
    }

    public void setItemContainer(String itemContainer) {
        this.itemContainer = itemContainer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ModelClass(String name, String lastname, String email, String pass, String conpass) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.pass = pass;
        this.conpass = conpass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConpass() {
        return conpass;
    }

    public void setConpass(String conpass) {
        this.conpass = conpass;
    }


}
