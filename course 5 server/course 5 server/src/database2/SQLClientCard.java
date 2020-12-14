package database2;

import classes.Order;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLClientCard  implements IClientCard{

    private ConnectionDB dbConnection;
    private static SQLClientCard instance;

    public SQLClientCard() {
        dbConnection = ConnectionDB.getInstance();
    }

    public static synchronized SQLClientCard getInstance() {
        if (instance == null) {
            instance = new SQLClientCard();
        }
        return instance;
    }
   /* public ArrayList<Order> selectCollection() {
//
        String str = "select  client.id, client.number, name, surname, count(idorder)\n" +
                " from purchase\n" +
                " inner join clientcard on purchase.idclient=clientcard.idClient\n" +
                " group by purchase.idclient";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<Order> materials = new ArrayList<>();

        for (String[] items : result) {
            Order material = new Order();
            material.setId(Integer.parseInt(items[0]));
            material.setNumber(items[1]);
            material.setName((items[2]));
            material.setSurname(items[3]);
////            material.setDiscount(Integer.parseInt(items[5]));
            materials.add(material);
        }
        return materials;
    }

    public void add(Order collection) {
        try {
            String queryAdd = "INSERT into clientcard(phone_num, " +
                    "name, surname) VALUES (?,?,?)";
            PreparedStatement st = dbConnection.getConnect().prepareStatement(queryAdd);
            st.setString(1, collection.getNumber());
            st.setString(2, collection.getName());
            st.setString(3, collection.getSurname());
//            st.setInt(4, collection.getPurchases());
//            st.setInt(5, collection.getDiscount());


            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(Order material) {
        try {
            String REMOVE_GROUP = "DELETE FROM collection " + "WHERE idcollection = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(REMOVE_GROUP);
            statement.setInt(1, material.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateValue (double value, int id) {
        try {
            String UPDATE_NAME = "UPDATE collection " + "SET index1 = ?" +"WHERE idcollection = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setDouble(1, value);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}*/
   @Override
   public void insert(Order obj) {
       String str = "INSERT INTO client (id, name, surname, number, car, order, cost)" +
               " VALUES('" + obj.getId() + "'," +
               " '" + obj.getName() + "', '" + obj.getSurname() + "', " + "'," +
               " '" + obj.getNumber() + "', '" + obj.getCar() + "', "+
               "'" + obj.getOrder() + "', '" + obj.getCost() +")";
       dbConnection.execute(str);

   }

    @Override
    public ArrayList<Order> selectCollections() {
        return null;
    }

    @Override
    public ArrayList<Order> selectOrder() {
        String str = "SELECT * From client";
        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<Order> details = new ArrayList<>();

        for (String[] items : result) {
            Order detail = new Order();
            detail.setId(Integer.parseInt(items[0]));
            detail.setName(items[1]);
            detail.setSurname(items[2]);
            detail.setNumber(items[3]);
            detail.setCar(items[4]);
            detail.setOrder(items[5]);
            detail.setCost(Double.parseDouble((items[6])));
            details.add(detail);
        }
        return details;
    }
    /*public ArrayList<String> selectMaterialNames(String a) throws SQLException {

        String str = "SELECT name From detail  Where firm = '"+ a +"'";

        ArrayList<String[]> result = dbConnection.getArrayResult(str);
        ArrayList<String> jewName = new ArrayList<>();

        for (String[] items : result) {
            jewName.add(items[0]);
        }
        return jewName;
    }*/
    @Override
    public void add(Order detail) {
        try {
            String queryAdd = "INSERT into client (name, firm, price) VALUES (?,?,?)";
            PreparedStatement st = dbConnection.getConnect().prepareStatement(queryAdd);
            st.setString(1, detail.getName());
            st.setString(2, detail.getSurname());
            st.setString(3, detail.getNumber());
            st.setString(4, detail.getCar());
            st.setString(5, detail.getOrder());
            st.setDouble(8, detail.getCost());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void delete(Order detail) {
        try {
            String REMOVE_GROUP = "DELETE FROM client " + "WHERE id = ?";
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
            String UPDATE_NAME = "UPDATE client " + "SET cost = ?" +"WHERE id = ?";
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
            String UPDATE_NAME = "UPDATE client " + "SET  name = ?" + "WHERE id = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateSurname(String name, int id) {
        try {
            String UPDATE_NAME = "UPDATE client " + "SET surname = ?" + "WHERE id = ?";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }}

        @Override
        public void updateNumber(String name, int id) {
            try {
                String UPDATE_NAME = "UPDATE client " + "SET  number = ?" + "WHERE id = ?";
                PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
                statement.setString(1, name);
                statement.setInt(2, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void updateCar(String name, int id) {
            try {
                String UPDATE_NAME = "UPDATE client " + "SET car = ?" + "WHERE id = ?";
                PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
                statement.setString(1, name);
                statement.setInt(2, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }}
            @Override
            public void updateOrder(String name, int id) {
                try {
                    String UPDATE_NAME = "UPDATE client " + "SET  order = ?" + "WHERE id = ?";
                    PreparedStatement statement = dbConnection.getConnect().prepareStatement(UPDATE_NAME);
                    statement.setString(1, name);
                    statement.setInt(2, id);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
}