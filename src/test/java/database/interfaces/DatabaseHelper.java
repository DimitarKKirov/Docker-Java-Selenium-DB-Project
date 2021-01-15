package database.interfaces;



import localDataBaseCreationRelatedFiles.POJOForTables.AllDataTables;
import localDataBaseCreationRelatedFiles.POJOForTables.Items;

import java.util.List;

/**
 * interface for method guidance,
 * methods are used for database operations
 */
public interface DatabaseHelper {


    List<AllDataTables> getAllData();
    int getItemsCount();
    int getItemsDetailsCount();
    int getLoadCount();
    Items getItemByID(int ID);



}
