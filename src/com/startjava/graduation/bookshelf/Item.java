package com.startjava.graduation.bookshelf;

public enum Item {
    ERROR("0"),
    ADD("1"),
    FIND("2"),
    DELETE("3"),
    CLEAR("4"),
    EXIT("5");

    private final String item;

    Item(String item) {
        this.item = item;
    }

    public static Item getName(int index) {
        if (index >= 0 && index < values().length) {
            return values()[index];
        }
        return ERROR;
    }
}
