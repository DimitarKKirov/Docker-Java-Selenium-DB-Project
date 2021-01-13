package DataBase.DAO;

import DataBase.Driver.OracleDatabaseDriver;
import DataBase.POJO.Items;

public class TablesOracle {

    private OracleDatabaseDriver Driver;

    public TablesOracle(OracleDatabaseDriver Driver) {
        this.Driver = Driver;
    }

    public void oracleConnection() {
        Driver.createOracleConnection();
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
