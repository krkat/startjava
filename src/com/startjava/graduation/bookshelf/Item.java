package com.startjava.graduation.bookshelf;

public enum Item {
    ERROR_ITEM("0"),
    ADD_ITEM("1"),
    FIND_ITEM("2"),
    DELETE_ITEM("3"),
    CLEAR_ITEM("4"),
    EXIT_ITEM("5");

    private final String item;

    Item(String item) {
        this.item = item;
    }

    public static Item getInstance(int index) {
        if (index >= 0 && index < values().length) {
            return values()[index];
        }
        return ERROR_ITEM;
    }
}
