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

    @ManyToMany
    @JoinTable(name ="mapping_table", inverseJoinColumns = @JoinColumn(name="table2_id"), joinColumns = @JoinColumn(name="table1_id"))
    private List<Table2> table2List;


}
