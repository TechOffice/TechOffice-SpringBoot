package com.techoffice.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Model {

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date modeDate;

}
