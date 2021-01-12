package DataBase.src.test.java.POJO;

/**
 * This class represents the all data Tables in Oracle database
 */
public class OracleTables {


    private int itemSerialNumber;
    private String itemName;
    private int itemQuantity;
    private int itemID;
    private double itemPaidPricePerPiece;
    private double itemSellingPrice;

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

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public double getItemPaidPricePerPiece() {
        return itemPaidPricePerPiece;
    }

    public void setItemPaidPricePerPiece(double itemPaidPricePerPiece) {
        this.itemPaidPricePerPiece = itemPaidPricePerPiece;
    }

    public double getItemSellingPrice() {
        return itemSellingPrice;
    }

    public void setItemSellingPrice(double itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    public OracleTables(int itemSerialNumber, String itemName, int itemQuantity, int itemID, double itemPaidPricePerPiece, double itemSellingPrice) {
        this.itemSerialNumber = itemSerialNumber;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemID = itemID;
        this.itemPaidPricePerPiece = itemPaidPricePerPiece;
        this.itemSellingPrice = itemSellingPrice;
    }
}