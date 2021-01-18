package database.POJO;


import localDataBaseCreationRelatedFiles.dataBaseConnectionProperties.Paths;

/**
 * This class represents the database Table Items
 */
public class Items implements Paths {


    private int itemSerialNumber;
    private String itemName;


    public int getItemSerialNumber() {
        return itemSerialNumber;
    }

    public void setItemSerialNumber(int itemSerialNumber) {
        this.itemSerialNumber = itemSerialNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


}
