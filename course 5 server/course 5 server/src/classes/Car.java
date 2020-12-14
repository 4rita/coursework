package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Car implements Serializable {
        private int idcar;
        private String idclient;
        private String mark;
        private String model;
        private String status;
        //private ArrayList<Jewellery> jewelleryArrayList;


        public Car() {}

    public  Car(String mark,String model,String status,String idclient)
    {
        this.mark=mark;
        this.model=model;
        this.status=status;
        //this.date =java.time.LocalDate.now();
        this.idclient= idclient;
        //this.jewelleryArrayList = jewelleryArrayList;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModel() {
        return model;
    }

    public int getIdcar() {
        return idcar;
    }

    public String getIdclient() {
        return idclient;
    }

    public String getMark() {
        return mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setIdcar(int idcar) {
        this.idcar = idcar;
    }

    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}

