package com.test.consolestore.console.enums;

public enum Command {
    SHOW_ORDERS,
    REMOVE_PRODUCT,
    TOTAL_QUANTITIES,
    CREATE_PRODUCT,
    CREATE_ORDER,
    SHOW_ORDER_BY_ID,
    DISCONNECT,
    SHOW_PRODUCTS,
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
