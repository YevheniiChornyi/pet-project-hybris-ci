package com.test.consolestore.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor

public class OrderItem implements Serializable {

    public OrderItem(Product product, Long quantity) {
        OrderItemId orderItemId = new OrderItemId();
        orderItemId.setProduct(product);
        this.orderItemId = orderItemId;
        this.quantity = Math.toIntExact(quantity);
    }

    @EmbeddedId
    @Setter
    @Getter
    private OrderItemId orderItemId;

    @ColumnDefault(value = "1")
    @Getter
    private int quantity;

    public String getProductName(){
        Product demoProduct = this.orderItemId.getProduct();
        return demoProduct.getName();
    }

    public int getItemPrice(){
        Product demoProduct = this.orderItemId.getProduct();
        return demoProduct.getPrice();
    }

    @Override
    public String toString() {
        return "OrderItem(Product=" + this.getProductName() + ", quantity=" + this.getQuantity() + ")";
    }
}
