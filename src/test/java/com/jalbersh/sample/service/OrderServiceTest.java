package com.jalbersh.sample.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

public class OrderServiceTest {
    private OrderService orderService;

    @Before
    public void setUp() throws Exception {
//        orderService = new OrderService();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetProperties() {
        Properties props = null;
        try {
//            props= orderService.getProperties("Sample");
//            assertNotNull(props);
//            assertEquals("sample.log",props.getProperty("logging.file"));
        } catch (Exception e) {
            assertNull(props);
        }
    }
}