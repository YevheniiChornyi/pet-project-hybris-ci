package com.test.consolestore.entity;

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
@ToString//rework
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
    private List<OrderItem> orderItems;
}
