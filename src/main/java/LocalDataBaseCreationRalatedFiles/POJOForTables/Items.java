package LocalDataBaseCreationRalatedFiles.POJOForTables;


import LocalDataBaseCreationRalatedFiles.DataBaseConnectionProperties.Paths;

/**
 * class representing the database Item Table
 * for filling the data in the table
 */
public class Items implements Paths {



    private String itemsSerialNumber;
    private String itemName;


    public String getItemsSerialNumber() {
        return itemsSerialNumber;
    }

    public void setItemsSerialNumber(String itemsSerialNumber) {
        this.itemsSerialNumber = itemsSerialNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Items(){}
    public Items(String itemsSerialNumber, String itemName) {
        this.itemsSerialNumber = itemsSerialNumber;
        this.itemName = itemName;
    }

}
