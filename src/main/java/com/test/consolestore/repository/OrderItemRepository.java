package com.test.consolestore.repository;

import com.test.consolestore.entity.OrderItem;
import com.test.consolestore.entity.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {

    @Query("SELECT new OrderItem(oi.orderItemId.product, SUM(oi.quantity)) from OrderItem oi GROUP BY oi.orderItemId.product.id")
    List<OrderItem> findAllWhichOrdered();
}
