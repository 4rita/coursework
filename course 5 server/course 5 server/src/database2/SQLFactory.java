package database2;



public  class SQLFactory extends AbstractFactory {
    @Override
    public database2.SQLUsers getUsers() {
        return SQLUsers.getInstance();
    }

    @Override
    public SQLMaterial getMaterial() {
        return SQLMaterial.getInstance();
    }

    @Override
    public SQLPurchase getPurchase() {
        return SQLPurchase.getInstance();
    }

    @Override
    public SQLCar getCar() {
        return SQLCar.getInstance();

    }
    @Override
    public SQLClientCard getClientCard() {
        return SQLClientCard.getInstance();

    }


}
