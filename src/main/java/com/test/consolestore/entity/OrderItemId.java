package com.test.consolestore.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@RequiredArgsConstructor
@EqualsAndHashCode

public class OrderItemId implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    @Setter
    @Getter
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @Setter
    @Getter
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @Override
    public String toString() {
        if (orders != null) {
            return "OrderItemId{" +
                    "product=" + product.getId() +
                    ", orders=" + orders.getId() +
                    '}';
        } else {
            return "OrderItemId{" +
                    "product=" + product.getId() +
                    '}';
        }

    }
}
