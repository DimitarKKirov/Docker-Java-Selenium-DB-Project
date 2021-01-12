package DataBase.src.test.java.sqlRequests;

/**
 * interface storing the database sql queries for Mysql database
 */
public interface SQLQueries {


    String getALL=" select * from testdatamysql.Items ,testdatamysql.ItemsDetails ,testdatamysql.ItemsLoadingDetails ";
    String getItemByID = "select ItemSerialNumber, ItemName from Items where itemID = ";
    String getItemsDetailsByID = "select itemID from ItemsDetails where itemID = ";
    String getLoadItemByID = "select itemID from ItemsLoadingDetails where itemID =";
    String getItemByNames = "select from items where ItemName=";
    String getItemsCount = "select count(*) from Items;";
    String getItemsDetailsCount="select count(*) from ItemsDetails";
    String getLoadItemCount = "select count(*) from ItemsLoadingDetails";



}
