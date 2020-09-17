package com.techoffice.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Table1 {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "table1")
    private List<Table2> table2List;


}
