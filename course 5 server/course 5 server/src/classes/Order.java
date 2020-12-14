package classes;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String number;
    private String car;
    private String order;
    private double cost;

    public Order(String name, String surname, String number, String purchases) {
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.order = purchases;
        this.cost = cost;
    }

    public Order() {
    }

    public Order(int id, String name, String surname, String number, String purchases, double discount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.order = purchases;
        this.cost = discount;
    }

    public Order(String name, String surname, String number) {

        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
