package com.test.consolestore.service;

import com.test.consolestore.entity.Orders;
import com.test.consolestore.entity.User;
import com.test.consolestore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Orders saveOrder(User user, Scanner scanner) {

        System.out.println("Creating order");
        System.out.println("Input status:");

        String status = scanner.next();
        Orders orders = new Orders();
        orders.setStatus(status);
        orders.setCreatedAt(GregorianCalendar.getInstance().getTime());
        orders.setUser(user);
        return orderRepository.save(orders);
    }

    public void showAllOrdersForUser(User user) {
        System.out.println("Showing all current user's orders: ");
        orderRepository.findByUser(user).forEach(System.out::println);
    }

    public void showOrderById(Scanner scanner) {
        System.out.println("Input id: ");
        Integer id = scanner.nextInt();
        System.out.println("Found order: " + orderRepository.findById(id));
    }
}