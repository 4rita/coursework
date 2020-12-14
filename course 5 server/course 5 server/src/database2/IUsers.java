package database2;

import classes.Users;
//import model.Passengers;

import java.util.ArrayList;


public interface IUsers {

    void insert(Users obj);
    public ArrayList<Users> selectUsers();
    public void add(Users user);
    public void delete(Users user);
    public void updateName (String name, int id);
    public void updateSurname(String name, int id);
    public void updatePassword(String name, int id);
    public void updateLogin(String name, int id);
    public void updatePassport(String name, int id) ;
}
