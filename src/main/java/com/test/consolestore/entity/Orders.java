package com.test.consolestore.entity;

import com.test.consolestore.util.creator.CurrentDate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String status;

    @Setter
    @Getter
    private Date createdAt;

    @ManyToOne
    @Setter
    @Getter
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    @Setter
    @Getter
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;//TODO without repetitions (only visual bug when creating) => wrong total price
    
    public int getTotalPrice(){
        int totalPrice = 0;
        for (OrderItem i :
            orderItems ) {
            totalPrice += (i.getItemPrice()* i.getQuantity());
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order(Id=" + this.getId() + ", status=" + this.getStatus() + ", Date=" + CurrentDate.currentDate(this.getCreatedAt())
                + ", total_price=" + this.getTotalPrice() + "\n" + orderItems +")";
    }
}
