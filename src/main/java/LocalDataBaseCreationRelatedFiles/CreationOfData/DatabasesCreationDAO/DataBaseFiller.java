package LocalDataBaseCreationRelatedFiles.CreationOfData.DatabasesCreationDAO;

import LocalDataBaseCreationRelatedFiles.DataBaseConnectionProperties.Paths;
import LocalDataBaseCreationRelatedFiles.POJOForTables.Items;
import LocalDataBaseCreationRelatedFiles.POJOForTables.ItemsDetails;
import LocalDataBaseCreationRelatedFiles.POJOForTables.ItemsLoadingDetails;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.knowm.yank.Yank;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * TestDataForMysql is a class that sends dummy data form Json file to a Mysql database
 * or any other that is configured
 * if the property files are changed wit the correct sql syntax
 * it can be use for other types of DB
 * This class uses Yank library
 * Yank can maintain only one connection at a time
 */
public class DataBaseFiller implements Paths {

    private String dataBase;
    private List<Items> itemName;
    private Items items;
    private List<ItemsDetails> itemsDetails;
    private ItemsDetails details;
    private List<ItemsLoadingDetails> itemsLoadingDetails;
    private ItemsLoadingDetails loadingDetails;


    /**
     * using Yank library, the method is sending sql request for creating tables
     * the Yank build in method send sql statement "TABLE_ITEMS" that is implemented from
     * the Paths interface, the value of the variable dataBase is set on connection creation
     * this sets witch database will be filled with dummy data
     */
    public void createOracleDBTables() {
        String items = dataBase + "_TABLE_ITEMS";
        Yank.executeSQLKey(items, null);
        String itemsDeatails = dataBase + "_TABLE_ITEMS_DETAILS";
        Yank.executeSQLKey(itemsDeatails, null);
        String storeLoading = dataBase + "_TABLE_ITEMS_STORE_LOADING_DETAILS";
        Yank.executeSQLKey(storeLoading, null);
    }

    /**
     * using Yank library, the method is creating connection using the variables in the file Connection.properties,
     * the keys must be with the same names as in this file
     * depending on the database name entered a corresponding connection is created
     * otherwise Yank does not recognises them (Yank version - 3.3.3)
     * with the sql statement the method is creating the tables in mysql
     */
    public void createConnection(String databaseName) {

        if (databaseName.equalsIgnoreCase("Oracle")) {
            Yank.setupDefaultConnectionPool(OracleConnection);
            Yank.addSQLStatements(OracleSql);
            dataBase = "ORACLE";
        } else if (databaseName.equalsIgnoreCase("Mysql")) {
            Yank.setupDefaultConnectionPool(MysqlConnection);
            Yank.addSQLStatements(MySql);
            dataBase = "MYSQL";
        } else if (databaseName.equalsIgnoreCase("Postgres")) {
            Yank.setupDefaultConnectionPool(PostgresConnection);
            Yank.addSQLStatements(PostgresSql);
            dataBase = "POSTGRES";
        }

    }


    /**
     * helper method for data preparation for table Items
     * from a json file (jsonPath) the method is taking
     * ItemName and ItemSerialNumber based on the key-pare value
     * and adding them in a global arraylist itemName
     */
    void itemsFieldsPrepareData(String nameOfData) {
        String jsonPath;
        if (nameOfData.equalsIgnoreCase("Correct")) {
            jsonPath = CorrectDummyData;
        } else {
            jsonPath = WrongDummyData;
        }
        JSONParser reader = new JSONParser();
        itemName = new ArrayList<>();
        try {
            String name;
            String serial;
            FileReader fileReader = new FileReader(jsonPath);
            Object temp = reader.parse(fileReader);
            JSONArray jsTemp = (JSONArray) temp;
            for (Object o : jsTemp) {
                JSONObject tempJson = (JSONObject) o;
                if (tempJson.containsKey("ItemName") && tempJson.containsKey("ItemSerialNumber")) {
                    name = tempJson.get("ItemName").toString();
                    serial = tempJson.get("ItemSerialNumber").toString();
                    items = new Items(serial, name);
                    itemName.add(items);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * from the global arraylist itemName
     * data is pulled out
     * and send to the database with Yank execute method
     */
    public void populateItems() {
        System.out.println(itemName.size());
        Object[][] tempObj = new Object[itemName.size()][];
        for (int i = 0; i < itemName.size(); i++) {
            Items item = itemName.get(i);

            tempObj[i] = new Object[]{item.getItemsSerialNumber(), item.getItemName()};
        }
        String sql = dataBase + "TableItemsFill";
        Yank.executeBatchSQLKey(sql, tempObj);
    }

    /**
     * helper method for data preparation for table itemsDetails
     * from a json file (jsonPath) the method is taking
     * ItemQuantity, ItemSellingPrice and ItemID based on the key-pare value
     * and adding them in a global arraylist itemsDetails
     */
    void itemsDetailsFields(String nameOfData) {
        String jsonPath;
        if (nameOfData.equalsIgnoreCase("Correct")) {
            jsonPath = CorrectDummyData;
        } else {
            jsonPath = WrongDummyData;
        }
        JSONParser reader = new JSONParser();
        itemsDetails = new ArrayList<>();
        try {

            FileReader fileReader = new FileReader(jsonPath);
            Object temp = reader.parse(fileReader);
            JSONArray jsTemp = (JSONArray) temp;
            for (Object o : jsTemp) {
                JSONObject tempJson = (JSONObject) o;
                if (tempJson.containsKey("ItemQuantity") && tempJson.containsKey("ItemSellingPrice") && tempJson.containsKey("ItemID")) {
                    String quantity = tempJson.get("ItemQuantity").toString();
                    String selPrice = tempJson.get("ItemSellingPrice").toString();
                    String fItemID = tempJson.get("ItemID").toString();
                    details = new ItemsDetails(quantity, selPrice, fItemID);
                    itemsDetails.add(details);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * from the global arraylist itemsDetails
     * data is pulled out
     * and send to the database with Yank execute method Yank.executeBatchSQLKey(String, Object[][])
     */
    public void populateItemsDetails() {
        System.out.println(itemsDetails.size());
        Object[][] tempObj = new Object[itemsDetails.size()][];
        for (int i = 0; i < itemsDetails.size(); i++) {
            ItemsDetails item = itemsDetails.get(i);

            tempObj[i] = new Object[]{item.getItemQuantity(), item.getItemSellingPrice(), item.getItemID()};
        }
        String sql = dataBase + "TableItemDetails";
        Yank.executeBatchSQLKey(sql, tempObj);
    }

    /**
     * helper method for data preparation for table loadingDetails
     * from a json file (jsonPath) the method is taking
     * ItemPaidPricePerPiece and DetailsID based on the key-pare value
     * and adding them in a global arraylist itemsLoadingDetails
     */
    void itemsLoadingDetailsFields(String nameOfData) {
        String jsonPath;
        if (nameOfData.equalsIgnoreCase("Correct")) {
            jsonPath = CorrectDummyData;
        } else {
            jsonPath = WrongDummyData;
        }
        JSONParser reader = new JSONParser();
        itemsLoadingDetails = new ArrayList<>();
        try {
            String name = null;
            String serial = null;
            FileReader fileReader = new FileReader(jsonPath);
            Object temp = reader.parse(fileReader);
            JSONArray jsTemp = (JSONArray) temp;
            for (Object o : jsTemp) {
                JSONObject tempJson = (JSONObject) o;
                if (tempJson.containsKey("ItemPaidPricePerPiece") && tempJson.containsKey("DetailsID")) {
                    String paidPrice = tempJson.get("ItemPaidPricePerPiece").toString();
                    String detailsID = tempJson.get("DetailsID").toString();
                    loadingDetails = new ItemsLoadingDetails(paidPrice, detailsID);
                    itemsLoadingDetails.add(loadingDetails);
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * from the global arraylist itemsLoadingDetails
     * data is pulled out
     * and send to the database with Yank execute method Yank.executeBatchSQLKey(String, Object[][])
     */
    public void populateLoadingDetails() {
        System.out.println(itemsLoadingDetails.size());
        Object[][] tempObj = new Object[itemsLoadingDetails.size()][];
        for (int i = 0; i < itemsLoadingDetails.size(); i++) {
            ItemsLoadingDetails item = itemsLoadingDetails.get(i);

            tempObj[i] = new Object[]{item.getItemPaidPricePerPiece(), item.getDetailsID()};
        }
        String sql = dataBase + "TableItemsLoadingDetails";
        Yank.executeBatchSQLKey(sql, tempObj);
    }

    /**
     * the method is using the build in method of Yank library
     * for closing the connection to the database
     */
    public void closeConnection() {
        Yank.releaseAllConnectionPools();
    }


}
