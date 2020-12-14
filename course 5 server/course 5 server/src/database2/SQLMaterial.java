package database2;

import classes.Detail;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLMaterial  implements IMaterials{
    private ConnectionDB dbConnection;
    private static SQLMaterial instance;

    public SQLMaterial() {
        dbConnection = ConnectionDB.getInstance();
    }

    public static synchronized SQLMaterial getInstance() {
        if (instance == null) {
            instance = new SQLMaterial();
        }
        return instance;
    }
    @Override
    public void insert(Detail obj) {
        String str = "INSERT INTO detail (iddetail, name, firm, price)" +
                " VALUES('" + obj.getId() + "'," +
                " '" + obj.getName() + "', '" + obj.getFirm() + "', " +
                "'" + obj.getPrice() + ")";
        dbConnection.execute(str);

    }

    public ArrayList<Detail> selectMaterials() {
//
        String str = "SELECT * From detail";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<Detail> details = new ArrayList<>();

        for (String[] items : result) {
            Detail detail = new Detail();
            detail.setId(Integer.parseInt(items[0]));
            detail.setName(items[1]);
            detail.setFirm(items[2]);
            detail.setPrice(Double.parseDouble((items[3])));
            details.add(detail);
        }
        return details;
    }
    public ArrayList<String> selectMaterialNames() throws SQLException {

        String str = "SELECT name From detail ";

        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<String> jewName = new ArrayList<>();

        for (String[] items : result) {
            jewName.add(items[0]);
        }
        return jewName;
    }

    @Override
    public void add(Detail detail) {
        try {
            String queryAdd = "INSERT into detail (name, firm, price) VALUES (?,?,?)";
            PreparedStatement st = dbConnection.getConnect().prepareStatement(queryAdd);
            st.setString(1, detail.getName());
            st.setString(2, detail.getFirm());
            st.setDouble(3, detail.getPrice());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void delete(Detail detail) {
        try {
            String REMOVE_GROUP = "DELETE FROM detail " + "WHERE id = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(REMOVE_GROUP);
            statement.setInt(1, detail.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateValue (double value, int id) {
        try {
            String UPDATE_NAME = "UPDATE detail " + "SET price = ?" +"WHERE id = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setDouble(1, value);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateName(String name, int id) {
        try {
            String UPDATE_NAME = "UPDATE detail " + "SET  name = ?" + "WHERE id = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateFirm(String name, int id) {
        try {
            String UPDATE_NAME = "UPDATE detail " + "SET firm = ?" + "WHERE id = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public double selectPrice(String name) {
        String query = "SELECT price From detail Where name ='" + name +"'";
        ArrayList<String[]> result = dbConnection.getArrayResult(query);
        double price = 0;
        for (String[] items : result) {

            price = Double.parseDouble(items[0]);

        }

        return price;
    }



}
