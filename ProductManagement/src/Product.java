
public class Product {
    private String productName;
    private String productID;
    private float unitPrice;
    private String status;
    private int quantity;

    public Product() {
    }

    public Product(String productName, String productID, float unitPrice, String status, int quantity) {
        this.productName = productName;
        this.productID = productID;
        this.unitPrice = unitPrice;
        this.status = status;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductID() {
        return productID;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public String getStatus() {
        return status;
    }

    public int getQuantity() {
        return quantity;
    }

    
    @Override
    public String toString() {
        return  productName + ", " + productID + ", " + unitPrice + ", " + status + ", " + quantity;
    }
    
    
}
