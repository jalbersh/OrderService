package com.jalbersh.sample.controller;

import com.jalbersh.sample.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations={"classpath:app-context.xml"})
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebServerControllerTest {

    OrderService orderService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @InjectMocks
    private WebServerController con;
    private MockMvc mvc;

    @Before
    public void setup() throws Exception {
        try {
            mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//            orderService = new OrderService();
//            con = new WebServerController();
            MockitoAnnotations.initMocks(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIt() {
        assertTrue(true);
    }

}