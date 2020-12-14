package database2;

import classes.Car;

import java.util.ArrayList;

public interface ICar {
    void insert(Car obj);

    public ArrayList<Car> selectCar();

    public void add(Car user);

    public void delete(Car user);

    public void updateMark(String name, int id);

    public void updateModel(String name, int id);

    public void updateStatus(String name, int id);

    public void updateIdclient(String name, int id);
}
