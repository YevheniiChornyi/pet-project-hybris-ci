package com.test.consolestore;

import com.test.consolestore.console.enums.Command;
import com.test.consolestore.entity.User;
import com.test.consolestore.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class ConsolestoreApplication implements CommandLineRunner {

    private final CommandService commandService;

    public static void main(String[] args) {
        SpringApplication.run(ConsolestoreApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        User authorizedUser = commandService.authorizeOrCreateUser(scanner);

        commandService.printAllCommands();

        boolean isOn = true;
        while (isOn) {
            System.out.println("input command");
            Command command = Command.getCommand(scanner.next());

            switch (command) {

                case REMOVE_PRODUCT:
                    commandService.removeProduct(scanner);
                    break;

                case SHOW_ORDER_BY_ID:
                    commandService.showOrderById(scanner);
                    break;

                case TOTAL_QUANTITIES:
                    commandService.showAll();
                    break;

                case SHOW_PRODUCTS:
                    commandService.showAllProducts();
                    break;

                case SHOW_ORDERS:
                    commandService.showAllOrdersForUser(authorizedUser);
                    break;

                case CREATE_PRODUCT:
                    commandService.createProduct(scanner);
                    break;

                case CREATE_ORDER:
                    try {
                        commandService.createOrder(authorizedUser, scanner);
                    } catch (NullPointerException e) {
                        System.out.println("Order has not been created");
                        break;
                    }
                    break;

                case HELP:
                    commandService.printAllCommands();
                    break;

                case DISCONNECT:
                    isOn = false;
                    break;

                case WRONG_COMMAND:
                default:
                    break;
            }
        }
    }
}
