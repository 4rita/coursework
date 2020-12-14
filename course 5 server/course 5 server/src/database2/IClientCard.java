package database2;

import classes.Order;

import java.util.ArrayList;

public interface IClientCard {
    public void insert(Order obj);
    public ArrayList<Order> selectCollections();
    public void add(Order user);
    public void delete(Order user);
    public void updateName (String name, int id);
    public void updateOrder(String name, int id) ;
    public void updateCar(String name, int id) ;
    public void updateNumber(String name, int id) ;
    public void updateSurname(String name, int id) ;
    public void updateValue (double value, int id) ;
    public ArrayList<Order> selectOrder() ;
}
