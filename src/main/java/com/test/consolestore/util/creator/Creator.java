package com.test.consolestore.util.creator;

import java.util.Scanner;

public interface Creator<E> {
    void create(E requiredEntity, Scanner scanner);
}
