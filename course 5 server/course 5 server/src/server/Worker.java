package server;

import classes.*;
import classes.Error;
import database2.*;

import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;


public class Worker implements Runnable {
    protected Socket clientSocket = null;
    ObjectInputStream sois;
    ObjectOutputStream soos;

    public Worker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            SQLFactory sqlFactory = new SQLFactory();

            sois = new ObjectInputStream(clientSocket.getInputStream());
            soos = new ObjectOutputStream(clientSocket.getOutputStream());
            while (true) {
                String choice = sois.readObject().toString();
                switch (choice) {

                    case "enter": {
                        String user = sois.readObject().toString();
                        String pass = (String) sois.readObject().toString();
                        String url = "jdbc:mysql://localhost/course3?serverTimezone=Europe/Minsk&useSSL=false";
                       // Class.forName("com.mysql.jdbc.Driver");
                        Connection myConn = DriverManager.getConnection(url, "root", "root");
                        Statement mySt = myConn.createStatement();
                        ResultSet myRs = mySt.executeQuery("select * from user");
                        int flag = 0;
                        while (myRs.next()) {
                            if (user.equals(myRs.getString("login"))
                                    && pass.equals(myRs.getString("pass"))) {
                                if (myRs.getBoolean("isAdmin")) {
                                    soos.writeObject("Yes1");
                                    System.out.println("���� ��� ���������������");
                                } else {
                                    soos.writeObject("Yes0");
                                    System.out.println("���� ��� �������������");

                                }
                                flag = 1;
                            }

                        }
                        if (flag == 0)
                            soos.writeObject("No");
                        System.out.println("���� �� �����������");

                        System.out.println(user + " " + pass);
                        break;
                    }
// ----------------------------------Users----------------------------------------------
                    case "updUsers": {
                        System.out.println("������ �� �������������� ������ ������������ � ��");

                        int num = (Integer) sois.readObject();
                        String name = (String) sois.readObject();
                        String str = (String) sois.readObject();

                        switch (str){
                            case "���": {
                                System.out.println("������ �� �������������� ����� ������������ � ��");
                                sqlFactory.getUsers().updateName(name, num);
                                break;}
                            case "�����": {
                                System.out.println("������ �� �������������� ������ � ��");
                                sqlFactory.getUsers().updateLogin(name, num);
                                break;}
                            case "������": {
                                System.out.println("������ �� �������������� ������ ������������ � ��");
                                sqlFactory.getUsers().updatePassword(name, num);break;}
                            case "����� ��������": {
                                System.out.println("������ �� �������������� ������ �������� ������������ � ��");

                                sqlFactory.getUsers().updatePassport(name, num);
                                break;}
                            case "�������": {
                                System.out.println("������ �� ������� ������������ � ��");

                                sqlFactory.getUsers().updateSurname(name, num);
                                break;}

                        }

                        break;
                    }
                    case "showUsers": {
                        System.out.println("������ �� �������� ������� �������������");

                        SQLUsers s = new SQLUsers();
                        ArrayList<Users> user1 = s.selectUsers();
                        soos.writeObject(user1);
                        break;
                    }
                    case "addUser": {
                        System.out.println("������ �� ���������� ������������� � ��");

                        Users user = (Users) sois.readObject();
                        sqlFactory.getUsers().add(user);
                        break;
                    }
                    case "deleteUser": {
                        System.out.println("������ �� �������� ������������ �� ��");


                        Users user = (Users) sois.readObject();
                        sqlFactory.getUsers().delete(user);
                        break;
                    }
                    // ----------------------------------Car----------------------------------------------
                    case "updCars": {
                        System.out.println("������ �� ��������������  ����������� � ��");

                        int num = (Integer) sois.readObject();
                        String name = (String) sois.readObject();
                        String str = (String) sois.readObject();

                        switch (str){
                            case "�����": {
                                System.out.println("������ �� ��������������  ����� ���������� � ��");
                                sqlFactory.getCar().updateMark(name, num);
                                break;}
                            case "������": {
                                System.out.println("������ �� ��������������  ������ ���������� � ��");
                                sqlFactory.getCar().updateModel(name, num);
                                break;}
                            case "������": {
                                System.out.println("������ �� �������������� ������� ���������� � ��");
                                sqlFactory.getCar().updateStatus(name, num);}
                            case "������": {
                                System.out.println("������ �� �������������� ������ ������� � ��");

                                sqlFactory.getCar().updateIdclient(name, num);
                                break;}

                        }

                        break;
                    }
                    case "showCars": {
                        System.out.println("������ �� �������� ������� �����������");

                        SQLCar s = new SQLCar();
                        ArrayList<Car> user1 = s.selectCar();
                        soos.writeObject(user1);
                        break;
                    }
                    case "addCar": {
                        System.out.println("������ �� ���������� ������������� � ��");

                        Car user = (Car) sois.readObject();
                        sqlFactory.getCar().add(user);
                        break;
                    }
                    case "deleteCar": {
                        System.out.println("������ �� �������� ������������ �� ��");
                        Car user = (Car) sois.readObject();
                        sqlFactory.getCar().delete(user);
                        break;
                    }
//----------------Diarn   --
                    case "showPopularity":{
                        SQLError s = new SQLError();
                        String id = (String) sois.readObject();
                        soos.writeObject(s.itemsPopularitys(id));
                        break;
                    }
                    case "showPopularityA":{
                        SQLError s = new SQLError();
                       //String id = (String) sois.readObject();
                        soos.writeObject(s.itemsPopularity());
                        break;
                    }


                    case "showError": {
                        System.out.println("������ �� �������� ������ �������������");

                        SQLError s = new SQLError();
                        ArrayList<Error> user1 = s.selectError();
                        soos.writeObject(user1);
                        break;

                    }
                    case "checkId": {
                        String id = (String) sois.readObject();
                        SQLError s = new SQLError();
                        break;

                    }
                    case "SaveError": {
                       String telNumber = (String) sois.readObject();
                        //SQLError s = new SQLError();
                        SQLError s = new SQLError();
                        ArrayList<Error> user1 = s.selectErrorID(telNumber);
                        soos.writeObject(user1);
                        break;

                    }
                    case "SaveErrorUser": {
                        String telNumber = (String) sois.readObject();
                        SQLError s = new SQLError();
                        ArrayList<Error> user1 = s.selectErrorUser(telNumber);
                        soos.writeObject(user1);


                        break;

                    }

                    //----------------Details   -----------------------
                    case "showDetails": {
                        System.out.println("������ ����� �������");

                        SQLMaterial s = new SQLMaterial();
                        ArrayList<Detail> user1 = s.selectMaterials();
                        soos.writeObject(user1);
                        break;
                    }
                    case "addDetail": {
                        System.out.println("������ �� ���������� ������� � ��");

                        Detail user = ( Detail) sois.readObject();
                        sqlFactory.getMaterial().add(user);
                        break;
                    }
                    case "deleteDetail": {
                        System.out.println("������ �� �������� ������� �� ��");

                        Detail user = (Detail) sois.readObject();
                        sqlFactory.getMaterial().delete(user);
                        break;
                    }
                    case "updateDetails": {
                        System.out.println("������ �� �������������� ������  ������� � ��");

                        int num = (Integer) sois.readObject();
                        String name = (String) sois.readObject();
                        String str = (String) sois.readObject();


                        switch (str){
                            case "��������": {
                                System.out.println("������ �� �������������� �������� ������ � ��");
                                sqlFactory.getMaterial().updateName(name, num);
                                break;}
                            case "�����": {
                                System.out.println("������ �� �������������� ����� ������ � ��");
                                sqlFactory.getMaterial().updateFirm(name, num);
                                break;}
                            case "���������": {
                                Double value = Double.valueOf(name);
                                System.out.println("������ �� �������������� ��������� ������ � ��");
                                sqlFactory.getMaterial().updateValue(value, num);}

                        }

                        break;
                    }


                    //----------------Clients   -----------------------

                    case "showOrders": {
                        System.out.println("������ �� �������������� ������ �������");

                        SQLClientCard s = new SQLClientCard();
                        ArrayList<Order> user1 = s.selectOrder();
                        soos.writeObject(user1);
                        break;
                    }
                    case "deleteOrder": {
                        System.out.println("������ �� �������� ������ �� ��");

                        Order user = ( Order) sois.readObject();
                        sqlFactory.getClientCard().delete(user);
                        break;
                    }
                    case "updOrder": {
                        System.out.println("������ �� �������������� ������ � ��");

                        int num = (Integer) sois.readObject();
                        String name = (String) sois.readObject();
                        String str = (String) sois.readObject();


                        switch (str){
                            case "���": {
                                System.out.println("������ �� �������������� ����� � ��");
                                sqlFactory.getClientCard().updateName(name, num);
                                break;}
                            case "�������": {
                                System.out.println("������ �� �������������� ������� � ��");
                                sqlFactory.getClientCard().updateSurname(name, num);
                                break;}
                            case "� ��������": {
                                System.out.println("������ �� �������������� �������� � ��");
                                sqlFactory.getClientCard().updateNumber(name, num);
                                break;}
                            case "����������": {
                                System.out.println("������ �� �������������� ���������� ������� � ��");
                                sqlFactory.getClientCard().updateCar(name, num);
                                break;}
                            case "�����": {
                                System.out.println("������ �� �������������� ������ � ��");
                                sqlFactory.getClientCard().updateOrder(name, num);
                                break;}
                            case "���������": {
                                Double value = Double.valueOf(name);
                                System.out.println("������ �� �������������� ���������� ��������� � ��");
                                sqlFactory.getClientCard().updateValue(value, num);}
                        }
                        break;
                    }

                    //---------------------------------------

                    case "getNames": {
                        System.out.println("������ �� �������������� �������� �������");
                        SQLMaterial s = new SQLMaterial();
                        ArrayList<String> user1 = s.selectMaterialNames();
                        soos.writeObject(user1);
                        break;
                    }
                    case "getPrice":{
                        SQLMaterial s = new SQLMaterial();
                        String name = (String) sois.readObject();
                        soos.writeObject(s.selectPrice(name));
                        break;

                    }
                    case "showDetailU": {
                        System.out.println("������ �� �������������� ������ �������");
                        SQLMaterial s = new SQLMaterial();
                        ArrayList<Detail> user1 = s.selectMaterials();
                        soos.writeObject(user1);
                        break;

                    }
                    case "showCarU": {
                        System.out.println("������ �� �������������� ������ �����, ���������� �����������");
                        SQLCar s = new SQLCar();
                        ArrayList<Car> user1 = s.selectCar();
                        soos.writeObject(user1);
                        break;

                    }
//                    case "fillToAddJewellery": {
//                        System.out.println("������ �� �������������� ����� � ���������� ������� ��� ������������ ���������� � ��");
//
//                        SQLMaterial s = new SQLMaterial();
//                       // ArrayList<String> user1 = s.selectMaterialNames("������");
//                       // soos.writeObject(user1);
//                        //ArrayList<String> list = s.selectMaterialNames("�������");
//                       // soos.writeObject(list);
//                        SQLCollection s2 = new SQLCollection();
//                        ArrayList<String> list2 = s2.selectCollectionNames();
//                        soos.writeObject(list2);
//
//                        break;
//
//                    }


                    //----------------Purchase------------
                    case "checkCard": {
                        SQLMaterial s = new SQLMaterial();
                        String name = (String) sois.readObject();
                        System.out.println(name);
                        String price= String.valueOf(s.selectPrice(name));
                        soos.writeObject(price);
                        String telNumber = (String) sois.readObject();
                        System.out.println(telNumber);

                        SQLPurchase s1= new SQLPurchase();
                        ArrayList<String> clientCreds = s1.checkClient(telNumber,name,price);

                        if (clientCreds.size()==0) {
                            clientCreds.add("0");
                            clientCreds.add("0");
                        }
                        soos.writeObject(clientCreds);
                        break;

                    }
                    case "setPurchase": {
                        SQLPurchase s = new SQLPurchase();
                        ArrayList<String> names = (ArrayList<String>) sois.readObject();
                        String name =  (String) sois.readObject();
                        String surname =  (String) sois.readObject();
                        String idclient =  (String) sois.readObject();
                        s.setPurchases(names, idclient);
                        break;
                    }
                }
            }

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
