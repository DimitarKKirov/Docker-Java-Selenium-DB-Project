package DataBase.src.test.java.POJO;

/**
 * This class represents the database Table ItemsLoadingDetails
 */
public class ItemsLoadingDetails {

    private String itemPaidPricePerPiece;
    private String detailsID;

    public String getItemPaidPricePerPiece() {
        return itemPaidPricePerPiece;
    }

    public void setItemPaidPricePerPiece(String itemPaidPricePerPiece) {
        this.itemPaidPricePerPiece = itemPaidPricePerPiece;
    }

    public String getDetailsID() {
        return detailsID;
    }

    public void setDetailsID(String detailsID) {
        this.detailsID = detailsID;
    }

    public ItemsLoadingDetails(String itemPaidPricePerPiece, String detailsID) {
        this.itemPaidPricePerPiece = itemPaidPricePerPiece;
        this.detailsID = detailsID;
    }
}
