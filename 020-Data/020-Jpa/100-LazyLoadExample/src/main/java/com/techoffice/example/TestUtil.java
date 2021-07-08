package com.techoffice.example;

import com.techoffice.example.model.Table1;
import com.techoffice.example.model.Table2;

import java.util.List;

public class TestUtil {

    public static void test(List<Table1> table1List){
        for (Table1 table1: table1List){
            List<Table2> table2s = table1.getTable2List();
            System.out.println(table2s.size());
        }
    }
}
