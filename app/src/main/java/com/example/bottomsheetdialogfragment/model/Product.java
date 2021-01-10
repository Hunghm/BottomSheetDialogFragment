package com.example.bottomsheetdialogfragment.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
