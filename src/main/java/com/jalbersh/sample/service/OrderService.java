package com.jalbersh.sample.service;

import com.jalbersh.sample.model.MenuItem;
import com.jalbersh.sample.model.Order;
import com.jalbersh.sample.model.OrderRequest;
import com.jalbersh.sample.model.OrderResponse;
import com.jalbersh.sample.repository.MenuItemRepository;
import com.jalbersh.sample.repository.OrderRepository;
import com.jalbersh.sample.utils.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    MenuItemRepository menuItemRepository;

    OrderRepository orderRepository;

    MapService mapService;

    @Autowired
    public OrderService(MapService mapService, MenuItemRepository menuItemRepository, OrderRepository orderRepository) {
        this.mapService = mapService;
        this.menuItemRepository = menuItemRepository;
        this.orderRepository = orderRepository;
    }

    public Properties getProperties(String app) {
        Properties props = null;
        props = AppProperties.INSTANCE.getProperties();
        return props;
    }

    public OrderResponse placeOrder(OrderRequest request) {
        OrderResponse response = new OrderResponse();
        // calculate price of order - iterate thru items, summing the prices
        response.setPrice(calculateOrderPrice(request));
        // calculate delivery time - call rest endpoint, passing two addresses
        response.setDelivery_time(mapService.getTimeToDeliver(request));
        // timestamp order - SimpleDateFormat
        Date now = new Date();
        response.setOrder_time(now.toString());
        Order order = new Order();
        order.setOrder_time(response.getOrder_time());
        order.setExpected_delivery_time(response.getDelivery_time());
        order.setTotal_price(response.getPrice());
        order = orderRepository.save(order);
        response.setOrder(order.getId().toString());
        return response;
    }

    private String calculateOrderPrice(OrderRequest request) {
        Long sum = getTipFromString(request.getTip());
        // get items from menu
        for (String suuid : request.getItems()) {
            System.out.println("suid = "+suuid);
            UUID uuid = UUID.fromString(suuid);
            Optional<MenuItem> menuItem = menuItemRepository.findById(uuid);
            if (menuItem.isPresent()) {
                System.out.println("found "+suuid+":"+menuItem.get().getName()+":"+menuItem.get().getPrice());
                sum += menuItem.get().getPrice();
            }
            else {
                System.out.println(suuid+" not found");
            }
        }
        return "$"+String.valueOf(sum/100);
    }

    private Long getTipFromString(String input) {
        long tip = 0L;
        if (input == null) input = "$10.00";
        int decimal = input.indexOf(".");
        int dollarSign = input.indexOf("$");
        if (decimal > -1) {
            String dollars = input.substring(dollarSign+1,decimal);
            System.out.println("dollars="+dollars);
            tip += Long.parseLong(dollars)*100;
            String cents = input.substring(decimal+1);
            System.out.println("cents="+cents);
            tip += Long.parseLong(cents);
        }
        return tip;
    }
}
