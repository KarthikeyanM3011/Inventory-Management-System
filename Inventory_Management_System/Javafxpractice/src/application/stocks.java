package application;

public class stocks {
    private int productId;
    private int availableStock;
    private String productName;

    public stocks(int productId, int availableStock, String productName) {
        this.productId = productId;
        this.availableStock = availableStock;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
