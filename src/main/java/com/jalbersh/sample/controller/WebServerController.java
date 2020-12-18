package com.jalbersh.sample.controller;

import com.jalbersh.sample.model.OrderRequest;
import com.jalbersh.sample.model.OrderResponse;
import com.jalbersh.sample.service.MapService;
import com.jalbersh.sample.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * WebServerController handles the incoming requests from the Web Server
 */
@Api("Rest API for Sample WebServer operations")
@Controller
@CrossOrigin
public class WebServerController {
    private static final Logger logger = LoggerFactory.getLogger(WebServerController.class);

    private OrderService orderService;

    private MapService mapService;

    @Autowired
    public WebServerController(OrderService orderService, MapService mapService) {
        this.orderService = orderService;
        this.mapService = mapService;
    }

//    POST /api/order

    // Web client command to make official requests to an instance's application
    @ApiOperation(value = "Description: returns request", response = ResponseEntity.class)
    @RequestMapping(value="/api/order", method = RequestMethod.POST)
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
        logger.info("POST placeOrder");
        OrderResponse response = orderService.placeOrder(request);
        ResponseEntity<OrderResponse> result = ResponseEntity.accepted().body(response);
        return result;
    }

    // Web client command to make official requests to each instance Id connected to this Sample
    @ApiOperation(value = "Description: sets up database", response = ResponseEntity.class)
    @RequestMapping(value="/setup", method = RequestMethod.POST)
    public ResponseEntity<String> setUp() {
        logger.info("POST setup");
        mapService.setupDB();
        ResponseEntity<String> result = ResponseEntity.accepted().body("DB setup OK");
        return result;
    }

    // Web client command to make official requests to each instance Id connected to this Sample
    @ApiOperation(value = "Description: gets the database", response = ResponseEntity.class)
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public ResponseEntity<String> list() {
        logger.info("GET list");
        mapService.getDB();
        ResponseEntity<String> result = ResponseEntity.accepted().body("DB list OK");
        return result;
    }
}