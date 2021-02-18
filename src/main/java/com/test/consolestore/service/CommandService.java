package com.test.consolestore.service;

import com.test.consolestore.console.enums.Command;
import com.test.consolestore.util.creator.OrderCreator;
import com.test.consolestore.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
//TODO test this
public class CommandService {

    private final OrderService orderService;

    private final OrderCreator orderCreator;

    private final OrderItemService orderItemService;

    private final UserService userService;

    private final ProductService productService;

    public void printAllCommands() {
        System.out.println("All available commands: ");
        for (Command command : Command.values()) {
            System.out.println(command.toString() + "\n ------------------");
        }
    }

    public User authorizeOrCreateUser(Scanner scanner) {
        return userService.authorizeOrCreateUser(scanner);
    }

    public void createProduct(Scanner scanner) {
       productService.createProduct(scanner);
    }

    @Transactional
    public void createOrder(User user, Scanner scanner) {
        orderCreator.create(user, scanner);
    }

    public void showAllProducts() {
        productService.showAllProducts();
    }

    public void showAllOrdersForUser(User user) {
        orderService.showAllOrdersForUser(user);
    }

    public void showAll() {
        orderItemService.showAllWhichOrdered();
    }

    public void removeProduct(Scanner scanner) {
        productService.removeById(scanner);
    }

    public void showOrderById(Scanner scanner) {
        orderService.showOrderById(scanner);
    }
}
