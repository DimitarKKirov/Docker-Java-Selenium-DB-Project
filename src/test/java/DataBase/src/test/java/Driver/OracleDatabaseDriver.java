package DataBase.src.test.java.Driver;

import DataBase.src.test.java.POJO.*;
import DataBase.src.test.java.interfaces.DatabaseHelper;
import org.knowm.yank.Yank;
import DataBase.src.test.java.sqlRequests.OrcleQueries;

import java.util.List;
/**
 * this class implements methods for operating with the
 * Oracle database (or the set database)
 */
public class OracleDatabaseDriver extends DatabaseDriver implements OrcleQueries, DatabaseHelper {

    /*
        unused method in this class
        it needs to be overridden because of interface DatabaseHelper
     */
    @Override
    public List<MySQLItems> getAllData() {
        return null;
    }

    /**
     * method for retrieving data from all Tables in Oracle database
     *
     * @return method returns List of type OracleTables.class (POJO/Bean)
     * OracleTables.class represents all tables in Mysql database
     * it can be found in package POJO
     */
    @Override
    public List<OracleTables> getAllDataOracle() {
        return Yank.queryBeanList(orcleGetALL, OracleTables.class, null);
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
        String sql = orcleGetItemByID + iD;
        return Yank.queryBean(sql, Items.class, null);

    }
    /*
        unused method in this class
        it needs to be overridden because of interface DatabaseHelper
     */
    @Override
    public String getItemByIDNumber(int ID) {
        return null;
    }


    /**
     * method for retrieving data from table ItemDetails by filed ID
     *
     * @param ID method takes and int parameter and searches the
     *           connected database for fields that are
     *           with ID equal to the int variable using
     *           Yank library for sending the sql query
     * @return the return type of the method is a POJO class ItemsDetails
     * located in Pojo Package
     */
    @Override
    public ItemsDetails getItemDetailsByID(int ID) {
        String sql = orcleGetItemsDetailsByID + ID;
        return Yank.queryBean(sql, ItemsDetails.class, null);
    }

    /**
     * method for retrieving an ItemLoadingDetails data by filed ID
     *
     * @param ID method takes and int parameter and searches the
     *           connected database for fields that are
     *           with ID equal to the int variable using
     *           Yank library for sending the sql query
     * @return the return type of the method is a POJO class ItemsLoadingDetails
     * located in Pojo Package
     */
    @Override
    public ItemsLoadingDetails getItemLoadingDetailsByID(int ID) {
        String sql = orcleGetLoadItemByID + ID;
        return Yank.queryBean(sql, ItemsLoadingDetails.class, null);
    }

    /**
     * method returns filed count from the Table Items in the database
     *
     * @return the return type of this method is int
     * that represent the number of rows in the database table Items
     */
    @Override
    public int getItemsCount() {
        return Yank.queryScalar(orcleGetItemsCount, Integer.class, null);
    }

    /**
     * method retrieves the number of fields in the Table ItemsDetails
     *
     * @return the return type of this method is int
     * that represent the number of rows in the database table ItemsDetails
     */
    @Override
    public int getItemsDetailsCount() {
        return Yank.queryScalar(orcleGetItemsDetailsCount, Integer.class, null);
    }

    /**
     * method retrieves the number of fields in the Table ItemsLoadingDetails
     *
     * @return the return type of this method is int
     * that represent the number of rows in the database table ItemsLoadingDetails
     */
    @Override
    public int getLoadCount() {
        return Yank.queryScalar(orcleGetLoadItemCount, Integer.class, null);
    }

    /**
     * creating connection for Oracle database
     * the method is referring to the implemented method in
     * extended class DatabaseDriver
     */
    @Override
    public void createOracleConnection() {
        super.createOracleConnection();
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

    /**
     * method for retrieving an items data by item Name
     *
     * @param name method takes the String parameter that is passed for the name of the item
     *             and searches the database table Items
     *             using Yank library for sending the sql query
     * @return the return type of this method is String
     * the string contains the data of the fields that
     * contain the name of the item (the passed String parameter to the method)
     */
    @Override
    public String getItemByName(String name) {
        String sql = orcleGetItemByNames + name;
        return Yank.queryBean(sql, Items.class, null).toString();
    }
}
