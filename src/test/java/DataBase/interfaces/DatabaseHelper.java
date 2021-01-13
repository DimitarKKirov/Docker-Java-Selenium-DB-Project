package DataBase.interfaces;

import DataBase.POJO.*;
import DataBase.src.test.java.POJO.*;
import LocalDataBaseCreationRalatedFiles.src.test.java.POJO.*;

import java.util.List;

/**
 * interface for method guidance,
 * methods are used for database operations
 */
public interface DatabaseHelper {


    List<MySQLItems> getAllData();
    List<OracleTables> getAllDataOracle();
    int getItemsCount();
    int getItemsDetailsCount();
    int getLoadCount();
    String getItemByName(String name);
    Items getItemByID(int ID);
    String getItemByIDNumber(int ID);
    ItemsDetails getItemDetailsByID(int ID);
    ItemsLoadingDetails getItemLoadingDetailsByID(int ID);
}
