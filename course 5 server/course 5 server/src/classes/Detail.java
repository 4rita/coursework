package classes;
import java.io.Serializable;

public class Detail implements Serializable {
    private int id;
    private String name;
    private String firm;
    private double price;

    public Detail(String name, String firm,
                  double price) {
        this.name = name;
        this.firm = firm;
        this.price = price;
    }

    public Detail() {
    }

    public Detail(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getFirm() {
        return firm;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
