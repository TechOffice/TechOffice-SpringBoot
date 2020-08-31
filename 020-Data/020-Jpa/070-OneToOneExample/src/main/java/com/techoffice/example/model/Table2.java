package com.techoffice.example.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Data
@Entity
public class Table2 {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name="table_id")
    private Table1 table1;

    private Integer orderColumn;

    @PrePersist
    @PreUpdate
    public void updateOrder(){
        if (this.table1 != null && this.table1.getTable2List() != null ){
            int order = this.table1.getTable2List().indexOf(this) + 1;
            log.info("order updated: {}", order);
            this.setOrderColumn(order);
        }else {
            log.info("order failed to update");
        }

    }
}
