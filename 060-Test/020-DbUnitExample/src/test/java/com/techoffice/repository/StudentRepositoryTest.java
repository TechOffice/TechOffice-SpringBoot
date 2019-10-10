package com.techoffice.repository;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.techoffice.entity.Student;
import com.techoffice.repository.base.AbstractRepositoryTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@DatabaseSetup("classpath:/data/student.xml")
public class StudentRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void list(){
        List<Student> studentList = studentRepository.findAll();
        Assert.assertNotNull(studentList);
        Assert.assertTrue(studentList.size() > 0 );
    }
}
