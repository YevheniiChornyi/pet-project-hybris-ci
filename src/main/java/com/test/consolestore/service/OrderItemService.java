package com.test.consolestore.service;

import com.test.consolestore.entity.OrderItem;
import com.test.consolestore.entity.OrderItemId;
import com.test.consolestore.entity.Orders;
import com.test.consolestore.entity.Product;
import com.test.consolestore.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(Product product, Orders orders) {

        OrderItem orderItem = new OrderItem();

        OrderItemId orderItemId = new OrderItemId();
        orderItemId.setProduct(product);
        orderItemId.setOrders(orders);

        orderItem.setOrderItemId(orderItemId);

        return save(orderItem);
    }

    private OrderItem save(OrderItem orderItem) {
        OrderItemId orderItemId = orderItem.getOrderItemId();
        OrderItem orderItemFromDb = orderItemRepository.findById(orderItemId)
                .orElse(orderItem);
        int newQuantity = orderItemFromDb.getQuantity() + 1;
        orderItemFromDb.setQuantity(newQuantity);
        return orderItemRepository.save(orderItemFromDb);
    }

    public void showAllWhichOrdered() {
        orderItemRepository.findAllWhichOrdered().forEach(System.out::println);
    }
}
