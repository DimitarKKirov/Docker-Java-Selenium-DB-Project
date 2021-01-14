package DataBase.DAO;

import DataBase.Config.PostgresDatabaseOperations;
import DataBase.POJO.Items;

public class TablesPostgres {

    private PostgresDatabaseOperations Driver;

    public TablesPostgres(PostgresDatabaseOperations Driver) {
        this.Driver = Driver;
    }

    public void oracleConnection(String databaseName) {
        Driver.createConnection(databaseName);
    }

    public int getCountOracle() {
        return Driver.getItemsCount();
    }

    public Items getItemByIdOracle(int iD) {
        return Driver.getItemByID(iD);
    }

    public int getItemDetailsCountOracle() {
        return Driver.getItemsDetailsCount();
    }

    public int getLoadItemCountOracle() {
        return Driver.getLoadCount();
    }

    public void closeConnectionOracle() {
        Driver.closeConnection();
    }

}
