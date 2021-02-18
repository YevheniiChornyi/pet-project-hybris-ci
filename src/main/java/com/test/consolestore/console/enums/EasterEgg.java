package com.test.consolestore.console.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EasterEgg {
    PASSWORD("DELETE");

    private final String name;
}
