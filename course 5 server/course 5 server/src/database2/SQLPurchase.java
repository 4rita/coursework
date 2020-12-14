package database2;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLPurchase {

    private ConnectionDB dbConnection;
    private static SQLPurchase instance;

    public SQLPurchase() {
        dbConnection = ConnectionDB.getInstance();
    }

    public static synchronized SQLPurchase getInstance() {
        if (instance == null) {
            instance = new SQLPurchase();
        }
        return instance;
    }

    public ArrayList<String> checkClient(String clientTel,String order,String price) {
        ArrayList<String> materials = new ArrayList<>();
        try {
            String query = "SELECT name,surname,iduser From user Where passport ='" + clientTel + "'";
            PreparedStatement statement = dbConnection.getConnect().prepareStatement(query);
            ArrayList<String[]> result = dbConnection.getArrayResult(query);

            for (String[] items : result)
            {
                materials.add(items[0]);
                materials.add(items[1]);
                materials.add(items[2]);
            }
            if(materials.size()!=0) {
                //System.out.println(materials.get(2));
// выбрали имя фамилию
                //     ArrayList<String> materials1 = new ArrayList<>();
//                String query2 = "SELECT model From car Where idclient = '" + materials.get(2) + "'";
//                ArrayList<String[]> result2 = dbConnection.getArrayResult(query2);
//                for (String[] items : result2) {
//                    materials1.add(items[0]);
//                }
//                if(materials1.get(0)!="0"){
                //---вставляем в бд
                String car = "audi";
                String query3 = "INSERT into client (name, surname, number, car, client.order, client.cost) VALUES (?,?,?,?,?,?)";
                PreparedStatement st = dbConnection.getConnect().prepareStatement(query3);
                st.setString(1, materials.get(0));
                st.setString(2, materials.get(1));
                st.setString(3, clientTel);
                st.setString(4, car);
                st.setString(5, order);
                st.setDouble(6, Double.parseDouble(price));
                st.executeUpdate();
            }
            //else return materials;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return materials;
    }



    public void setPurchases(ArrayList<String> purchaseNames, String idClient) throws SQLException {

    }
}
