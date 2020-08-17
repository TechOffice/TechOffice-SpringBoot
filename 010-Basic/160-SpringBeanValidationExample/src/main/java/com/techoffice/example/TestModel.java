package com.techoffice.example;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TestModel {

    private String name;

    @NotBlank(message = "Address 1 cannot be blank")
    private String address1;

}
