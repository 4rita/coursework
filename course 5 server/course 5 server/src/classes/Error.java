package classes;

import java.io.Serializable;

public class Error implements Serializable {
    private int id;
    private String name;
    private double index;
    private String idclient;

    public Error(String name,  double index,String idclient) {
        this.name = name;
        this.index = index;
        this.idclient=idclient;
    }

    public Error() {
    }

    public Error(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getIndex() {
        return index;
    }

    public String getIdclient() {
        return idclient;
    }

    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public void setId(int id) {
        this.id = id;
    }
}



