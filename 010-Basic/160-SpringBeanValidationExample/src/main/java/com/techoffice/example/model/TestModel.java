package com.techoffice.example.model;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;

@Data
public class TestModel {

    private String name;

    @NotBlank(message = "Address 1 cannot be blank")
    private String address1;

    private String address2;

    @AssertFalse(message = "Address 1 and Address cannot be same")
    public boolean isAddressEqual(){
        return StringUtils.equals(address1, address2);
    }
}
