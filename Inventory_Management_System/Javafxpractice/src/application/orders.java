package application;

public class orders {
    private int order_id;
    private int product_id;
    private String order_status;
    private int order_quantity;
    private String product_name;

    public orders(int order_id, int product_id, String order_status, int order_quantity, String product_name) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.order_status = order_status;
        this.order_quantity = order_quantity;
        this.product_name = product_name;
    }
 
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public int getOrder_quantity() {
        return order_quantity;
    }

    public void setOrder_quantity(int order_quantity) {
        this.order_quantity = order_quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
