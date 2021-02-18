package com.test.consolestore.entity;

import com.test.consolestore.entity.enums.ProductStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
//TODO product_status
@Entity
@NoArgsConstructor
@ToString
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
}
