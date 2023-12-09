package application;

public class supply {
    private int supplier_id;
    private int product_id;
    private String productc_name;
    private String supplier_name;
    private int supply_quantity;

    public supply(int supplier_id, int product_id, String productc_name, String supplier_name, int supply_quantity) {
        this.supplier_id = supplier_id;
        this.product_id = product_id;
        this.productc_name = productc_name;
        this.supplier_name = supplier_name;
        this.supply_quantity = supply_quantity;
    }

    public int getSupplierId() {
        return supplier_id;
    }

    public int getProductId() {
        return product_id;
    }

    public String getProductcName() {
        return productc_name;
    }

    public String getSupplierName() {
        return supplier_name;
    }

    public int getSupplyQuantity() {
        return supply_quantity;
    }


    public void setSupplierId(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public void setProductcName(String productc_name) {
        this.productc_name = productc_name;
    }

    public void setSupplierName(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public void setSupplyQuantity(int supply_quantity) {
        this.supply_quantity = supply_quantity;
    }
}
