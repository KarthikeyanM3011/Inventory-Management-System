// Supplier.java
package application;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String email;
    private String location;
    private long mobile;

    public Supplier(int supplierId, String supplierName, String email, String location, long mobile) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.email = email;
        this.location = location;
        this.mobile = mobile;
    }

    // Getter and setter methods for each field
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}
