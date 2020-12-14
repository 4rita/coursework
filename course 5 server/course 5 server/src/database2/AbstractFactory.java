package database2;

//import database.*;

public abstract class AbstractFactory {
    public abstract SQLUsers getUsers();
    public abstract SQLMaterial getMaterial();
    public abstract SQLPurchase getPurchase();
    public abstract SQLCar getCar();

    public abstract SQLClientCard getClientCard();
//    public abstract SQLPlane getPlane();
//    public abstract SQLSchedule getSchedule();

//    public abstract SQLRout getRout();
//    public abstract SQLDate getDate();
//    public abstract SQLIndexOfPrice getIndexOfPrice();
//    public abstract SQLTicketsInSale getTicketsInSale();
//    public abstract SQLPassengers getPassengers();
//    public abstract SQLTicket getTicket();
}
