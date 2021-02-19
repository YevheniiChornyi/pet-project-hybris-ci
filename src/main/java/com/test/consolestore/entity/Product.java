package com.test.consolestore.entity;

import com.test.consolestore.entity.enums.ProductStatus;
import com.test.consolestore.util.creator.CurrentDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private int price;

    @Setter
    @Getter
    private ProductStatus productStatus;

    @Setter
    @Getter
    private Date createdAt;

    public String toString() {
        return "Product(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", productStatus=" + this.productStatus + ", createdAt=" + CurrentDate.currentDate(this.getCreatedAt()) + ")";
    }
}
