package database.config;

import database.driver.DatabaseDriver;
import database.POJO.*;
import database.interfaces.DatabaseHelper;
import database.sqlRequests.SQLQueries;
import org.knowm.yank.Yank;

import java.util.List;
/**
 * this class implements methods for operating with the
 * Oracle database (or the set database)
 */
public class PostgresDatabaseOperations extends DatabaseDriver implements SQLQueries, DatabaseHelper {


    /**
     * method for retrieving data from all Tables in Oracle database
     *
     * @return method returns List of type OracleTables.class (POJO/Bean)
     * OracleTables.class represents all tables in Mysql database
     * it can be found in package POJO
     */
    @Override
    public List<AllDataTables> getAllData() {
        return Yank.queryBeanList(getALL, AllDataTables.class, null);
    }

    /**
     * method for retrieving an Items data by filed ID
     *
     * @param iD method takes and int parameter and searches the
     *           connected database for fields that are
     *           with ID equal to the int variable using
     *           Yank library for sending the sql query
     * @return the return type of the method is a POJO class Items
     * located in Pojo Package
     */
    @Override
    public Items getItemByID(int iD) {
        String sql = getItemByID + iD;
        return Yank.queryBean(sql, Items.class, null);

    }


    /**
     * method returns filed count from the Table Items in the database
     *
     * @return the return type of this method is int
     * that represent the number of rows in the database table Items
     */
    @Override
    public int getItemsCount() {
        return Yank.queryScalar(getItemsCount, Integer.class, null);
    }

    /**
     * method retrieves the number of fields in the Table ItemsDetails
     *
     * @return the return type of this method is int
     * that represent the number of rows in the database table ItemsDetails
     */
    @Override
    public int getItemsDetailsCount() {
        return Yank.queryScalar(getItemsDetailsCount, Integer.class, null);
    }

    /**
     * method retrieves the number of fields in the Table ItemsLoadingDetails
     *
     * @return the return type of this method is int
     * that represent the number of rows in the database table ItemsLoadingDetails
     */
    @Override
    public int getLoadCount() {
        return Yank.queryScalar(getLoadItemCount, Integer.class, null);
    }

    /**
     * creating connection for Oracle database
     * the method is referring to the implemented method in
     * extended class DatabaseDriver
     */
    @Override
    public void createConnection(String databaseName) {
        super.createConnection(databaseName);
    }

    /**
     * method for closing connection
     * the method is referring to the implemented method in
     * extended class DatabaseDriver
     */
    @Override
    public void closeConnection() {
        super.closeConnection();
    }

}
