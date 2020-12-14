package database2;

import classes.Error;

import java.io.IOException;
import java.util.ArrayList;

public interface IError {
    public void insert(Error obj) ;
    public ArrayList<Error> selectError() ;
    public ArrayList<Error> selectErrorID(String ID) throws IOException;
}
