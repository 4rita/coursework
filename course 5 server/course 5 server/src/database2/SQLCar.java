package database2;

import classes.Car;
import classes.Users;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class SQLCar implements ICar {
    private ConnectionDB dbConnection;
    private static SQLCar instance;

    public SQLCar() {
        dbConnection = ConnectionDB.getInstance();
    }

    public static synchronized SQLCar getInstance() {
        if (instance == null) {
            instance = new SQLCar();
        }
        return instance;
    }

    @Override
    public void insert(Car obj) {
        String str = "INSERT INTO car (idcar, mark, model, status, idclient" +
                " ) VALUES('" + obj.getIdcar() + "'," +
                " '" + obj.getMark() + "', '" + obj.getModel() + "', " +
                "'" + obj.getStatus() + "', '" + obj.getIdclient()  + ")";
        dbConnection.execute(str);

    }


    @Override
    public ArrayList<Car> selectCar() {
//
        String str = "SELECT * From car";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<Car> User = new ArrayList<>();

        for (String[] items : result) {
            Car user = new Car();
            user.setIdcar(Integer.parseInt(items[0]));
            user.setMark(items[1]);
            user.setModel(items[2]);
            user.setStatus(items[3]);
            user.setIdclient(items[4]);
            User.add(user);

        }
        return User;
    }
    @Override
    public void add(Car user) {
        try {
            String queryAdd = "INSERT into car (idcar, mark, model, status, idclient) " +
                    " VALUES (?,?,?,?,?,?)";
            PreparedStatement st = dbConnection.getConnect().prepareStatement(queryAdd);
            st.setInt(1, user.getIdcar());
            st.setString(2, user.getMark());
            st.setString(3, user.getModel());
            st.setString(4, user.getStatus());
            st.setString(5, user.getIdclient());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Car user) {
        try {
            String REMOVE_GROUP = "DELETE FROM car " + "WHERE idcar = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(REMOVE_GROUP);
            statement.setInt(1, user.getIdcar());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMark(String name, int id) {
        try {
            String UPDATE_NAME = "UPDATE car" + "SET mark = ?" + "WHERE idcar = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateModel(String name, int id) {
        try {
            String UPDATE_NAME = "UPDATE car " + "SET model = ?" + "WHERE idcar = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateStatus(String name, int id) {
        try {
            String UPDATE_NAME = "UPDATE car " + "SET status = ?" + "WHERE idcar = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateIdclient(String name, int id) {
        try {
            String UPDATE_NAME = "UPDATE car " + "SET idñlient = ?" + "WHERE iduser = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
