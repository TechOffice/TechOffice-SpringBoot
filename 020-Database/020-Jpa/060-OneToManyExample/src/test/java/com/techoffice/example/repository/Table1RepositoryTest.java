package com.techoffice.example.repository;

import com.techoffice.example.model.Table1;
import com.techoffice.example.model.Table2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@TestPropertySource(properties = {
        "spring.jpa.properties.hibernate.ejb.interceptor=com.techoffice.example.repository.CustomSqlInterceptor"
})
@DataJpaTest
public class Table1RepositoryTest {

    @Autowired
    private Table1Repository table1Repository;

    @Autowired
    private EntityManager entityManager;

    @Before
    public void setup(){
        Assert.assertNotNull(table1Repository);
    }

    @Test
    public void insert(){
        Table1 table1Record1 = prepareTable1();
        table1Record1 = table1Repository.save(table1Record1);
        log.info("create record Id: {}", table1Record1.getId());
        entityManager.flush();

        Table1 table1Record2 = prepareTable1();
        table1Record2.setName("Table 2");
        table1Record2.setId(table1Record1.getId());
        table1Record2 = table1Repository.save(table1Record2);
        entityManager.flush();
        log.info("=====done=====");
    }

    private Table1 prepareTable1(){
        Table1 table1 = new Table1();
        List<Table2> table2List = new ArrayList<>();
        Table2 table2 = new Table2();
        table2List.add(table2);
        table1.setTable2List(table2List);
        return table1;
    }

}
