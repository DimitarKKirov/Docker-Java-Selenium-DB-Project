package DataBase.DAO;

import DataBase.Config.MySQLDatabaseOperations;

import DataBase.POJO.Items;

public class TablesMysql {

    private MySQLDatabaseOperations Driver;

    public TablesMysql(MySQLDatabaseOperations Driver) {
        this.Driver = Driver;
    }

    public void sqlConnection(String databaseName) {
        Driver.createConnection(databaseName);
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
