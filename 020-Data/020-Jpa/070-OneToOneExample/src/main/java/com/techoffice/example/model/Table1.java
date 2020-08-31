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

    @OneToMany(mappedBy = "table1", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Table2> table2List;

    @PrePersist
    @PreUpdate
    public void updateDependency(){
        if (this.table2List != null){
            for (Table2 table2: table2List){
                table2.setTable1(this);
            }
        }
    }

}
