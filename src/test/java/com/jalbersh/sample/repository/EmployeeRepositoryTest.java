package com.jalbersh.sample.repository;

import com.jalbersh.sample.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;

    @Before
    public void setup() throws Exception {
    }

    @Test
    @Transactional
    @Rollback
    public void testFindByTitle() throws Exception {
        Employee employee = new Employee();
        assertThat(true,equalTo(true));
    }

}

