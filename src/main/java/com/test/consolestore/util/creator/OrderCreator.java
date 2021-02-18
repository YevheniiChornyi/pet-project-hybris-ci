package com.test.consolestore.util.creator;

import com.test.consolestore.entity.OrderItem;
import com.test.consolestore.entity.Orders;
import com.test.consolestore.entity.User;
import com.test.consolestore.service.OrderItemService;
import com.test.consolestore.service.OrderService;
import com.test.consolestore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
//TODO test this
public class OrderCreator implements Creator<User> {

    private final OrderService orderService;

    private final ProductService productService;

    private final OrderItemService orderItemService;

    @Transactional
    @Override
    public void create(User user, Scanner scanner) {

        Orders savedOrders = orderService.saveOrder(user, scanner);

        List<OrderItem> orderItems = new ArrayList<>();

        while (true) {
            System.out.println("Input product id:");
            Integer productId = scanner.nextInt();

            orderItems.add(orderItemService.createOrderItem(productService.findProductById(productId), savedOrders));

            System.out.println("Wanna continue? yes/no");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("no")) {
                break;
            }
        }

        savedOrders.setOrderItems(orderItems);
        System.out.println("Order has been created " + savedOrders);
    }

}
