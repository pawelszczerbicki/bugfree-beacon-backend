package com.bugfree.web.application;

public enum Font {
    ROBOTO("Roboto"), ROBOTO_SLAB("Roboto Slab"), LATO("Lato");

    private String name;

    Font(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
