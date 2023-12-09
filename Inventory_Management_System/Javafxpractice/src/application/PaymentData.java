package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PaymentData {

    private final IntegerProperty paymentId;
    private final IntegerProperty orderId;
    private final DoubleProperty orderTotalPrice;
    private final IntegerProperty orderQuantity;

    public PaymentData(int paymentId, int orderId, double orderTotalPrice, int orderQuantity) {
        this.paymentId = new SimpleIntegerProperty(paymentId);
        this.orderId = new SimpleIntegerProperty(orderId);
        this.orderTotalPrice = new SimpleDoubleProperty(orderTotalPrice);
        this.orderQuantity = new SimpleIntegerProperty(orderQuantity);
    }

    public int getPaymentId() {
        return paymentId.get();
    }

    public IntegerProperty paymentIdProperty() {
        return paymentId;
    }

    public int getOrderId() {
        return orderId.get();
    }

    public IntegerProperty orderIdProperty() {
        return orderId;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice.get();
    }

    public DoubleProperty orderTotalPriceProperty() {
        return orderTotalPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity.get();
    }

    public IntegerProperty orderQuantityProperty() {
        return orderQuantity;
    }
}
