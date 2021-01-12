package DataBase.src.test.java.DAO;

import DataBase.src.test.java.Driver.MySQLDatabaseDriver;
import DataBase.src.test.java.POJO.*;

import java.util.List;

public class TablesMysql {

    private MySQLDatabaseDriver Driver;

    public TablesMysql(MySQLDatabaseDriver Driver) {
        this.Driver = Driver;
    }

    public void sqlConnection() {
        Driver.createMySQLConnection();
    }

    public int getCount() {
        return Driver.getItemsCount();
    }

    public Items getItemById(int iD) {
        return Driver.getItemByID(iD);
    }


    public int getItemDetailsCount() {
        return Driver.getItemsDetailsCount();
    }

    public int getLoadItemCount() {
        return Driver.getLoadCount();
    }

    public void closeConnectionMy() {
        Driver.closeConnection();
    }
}
