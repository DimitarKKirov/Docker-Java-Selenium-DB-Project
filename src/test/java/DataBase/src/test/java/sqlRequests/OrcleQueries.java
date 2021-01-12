package DataBase.src.test.java.sqlRequests;

/**
 * interface storing the database sql queries for Oracle database
 */
public interface OrcleQueries {

    String orcleGetALL=" select * from testdb.Items ,testdb.ItemsDetails ,testdb.ItemsLoadingDetails ";
    String orcleGetItemByID = "select ItemSerialNumber, ItemName from Items where item_ID = ";
    String orcleGetItemsDetailsByID = "select itemID from ItemsDetails where item_ID = ";
    String orcleGetLoadItemByID = "select itemID from ItemsLoadingDetails where item_ID =";
    String orcleGetItemByNames = "select from items where ItemName=";
    String orcleGetItemsCount = "select count(*) from ITEMS";
    String orcleGetItemsDetailsCount="select count(*) from ItemsDetails";
    String orcleGetLoadItemCount = "select count(*) from ItemsLoadingDetails";
}
