package com.techoffice.example.service;

import com.techoffice.example.model.Table1;
import com.techoffice.example.model.Table2;
import com.techoffice.example.repository.Table1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class Table1Service {

    @Autowired
    private Table1Repository table1Repository;

    @Transactional
    public Table1 initTable1Data(){
        Table1 table1 = new Table1();
        List<Table2> table2List = new ArrayList<>();
        Table2 table2 = new Table2();
        table2List.add(table2);
        table1.setTable2List(table2List);
        table1Repository.save(table1);
        return table1;
    }
}
