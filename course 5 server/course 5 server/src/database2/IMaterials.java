package database2;

import classes.Detail;
import classes.Users;

import java.util.ArrayList;

public interface IMaterials {
    void insert(Detail obj);
    public ArrayList<Detail> selectMaterials();
    public void add(Detail user);
    public void delete(Detail user);
    public void updateName (String name, int id);
    public void updateFirm(String name, int id);
    public void updateValue(double value, int id);


}
