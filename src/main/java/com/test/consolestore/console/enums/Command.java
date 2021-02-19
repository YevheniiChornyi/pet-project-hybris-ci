package com.test.consolestore.console.enums;

public enum Command {
    CREATE_PRODUCT,
    CREATE_ORDER,
    SHOW_ORDERS,
    SHOW_ORDER_BY_ID,
    SHOW_PRODUCTS,
    TOTAL_QUANTITIES,
    REMOVE_PRODUCT,
    DISCONNECT,
    WRONG_COMMAND, // ignore this
    HELP;

    public static Command getCommand(String commandName) {
        try {
            return Command.valueOf(commandName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return WRONG_COMMAND;
        }
    }

}
