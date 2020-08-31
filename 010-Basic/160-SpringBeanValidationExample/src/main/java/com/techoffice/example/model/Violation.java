package com.techoffice.example.model;

import lombok.Data;

@Data
public class Violation {

    private String path;
    private String message;

    public Violation(String path, String message) {
        this.path = path;
        this.message = message;
    }
}
