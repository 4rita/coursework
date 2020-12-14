package database2;
import classes.Error;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SQLError implements IError {
    private ConnectionDB dbConnection;
    private static SQLError instance;

    public SQLError() {
        dbConnection = ConnectionDB.getInstance();
    }

    public static synchronized SQLError getInstance() {
        if (instance == null) {
            instance = new SQLError();
        }
        return instance;
    }

    @Override
    public void insert(Error obj) {
        String str = "INSERT INTO error (id, name,index, idclient" +
                " ) VALUES('" + obj.getId() + "'," +
                " '" + obj.getName() + "', '" + obj.getIndex() + "', '" + obj.getIdclient()  + ")";
        dbConnection.execute(str);

    }
    @Override
    public ArrayList<Error> selectError() {
//
        String str = "SELECT * From error";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<Error> User = new ArrayList<>();

        for (String[] items : result) {
            Error user = new Error();
            user.setId(Integer.parseInt(items[0]));
            user.setName(items[1]);
            user.setIndex(Double.parseDouble(items[2]));
            user.setIdclient(items[3]);
            User.add(user);

        }
        return User;
    }
    public ArrayList<Error> selectErrorUser(String id) {
//
        String str = "SELECT name From error Where idclient='"+ id +"'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<Error> User = new ArrayList<>();

        ArrayList<String> result1=new ArrayList<>();

        for (String[] items : result) {
            Error user = new Error();
            user.setName(items[0]);
            User.add(user);
        }


        return User;
    }

    @Override
    public ArrayList<Error> selectErrorID(String ID) throws IOException {
//
        String str = "SELECT * From error  Where idclient='"+ ID + "'";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<Error> User = new ArrayList<>();
        Error user = new Error();
        BufferedWriter out = null;
        File file = new File("D:\\ашђр\\5.2\\src\\notes3.txt");
        out = new BufferedWriter(new FileWriter(file, false));
        for (String[] items : result) {
            user.setId(Integer.parseInt(items[0]));
            user.setName(items[1]);
            user.setIndex(Double.parseDouble(items[2]));
            user.setIdclient(items[3]);
            User.add(user);
            out.write(user.getName());
            out.write(" ");
            out.write(user.getIdclient());
            out.newLine();
        }
            out.close();

        return User;
    }
    public ArrayList<Error> itemsPopularity() {

        String query2 = "SELECT error.name,error.index From error ";

        ArrayList<String[]> result = dbConnection.getArrayResult(query2);
        ArrayList<Error> result2 = new ArrayList<>();
        for (String[] items : result) {
            Error statistics = new Error();
            statistics.setName(items[0]);
            statistics.setIndex(Double.parseDouble(items[1]));
            result2.add(statistics);
        }
        return result2;
    }
    public ArrayList<Error> itemsPopularitys(String id) {

        String query2 = "SELECT error.name,error.index From error WHERE idclient='"+ id +"'";

        ArrayList<String[]> result = dbConnection.getArrayResult(query2);
        ArrayList<Error> result2 = new ArrayList<>();
        for (String[] items : result) {
            Error statistics = new Error();
            statistics.setName(items[0]);
            statistics.setIndex(Double.parseDouble(items[1]));
            result2.add(statistics);
        }
        return result2;
    }
    }

