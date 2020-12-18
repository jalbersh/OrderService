package com.jalbersh.sample.service;

import com.jalbersh.sample.model.*;
import com.jalbersh.sample.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MapService {
    RestTemplate restTemplate;

    UserRepository userRepository;

    AddressRepository addressRepository;

    RestaurantRepository restaurantRepository;

    MenuRepository menuRepository;

    MenuItemRepository menuItemRepository;

    @Autowired
    public MapService(UserRepository userRepository, AddressRepository addressRepository, RestaurantRepository restaurantRepository,
                      MenuRepository menuRepository, MenuItemRepository menuItemRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Value( "${mapquest.consumer.key}" )
    private String consumerKey;

    @Value( "${mapquest.route.url}" )
    private String routeUrl;

    public void getDB() {
        Iterable<Restaurant> restaurants = restaurantRepository.findAll();
        for (Restaurant restaurant : restaurants) {
            System.out.println("restaurant id = "+restaurant.getId());
        }
        Iterable<MenuItem> items = menuItemRepository.findAll();
        for (MenuItem item : items) {
            System.out.println("item = "+item.getId()+": "+item.getName()+": "+item.getPrice());
        }
    }

    public void setupDB() {
        Address a = new Address();
        a.setAddress1("15193 W 63rd Ave,Arvada,CO 80403");
        a = addressRepository.save(a);
        System.out.println("address1 id = "+a.getId());
        User u = new User();
        u.setAddress(a);
        u.setName("James Albersheim");
        u = userRepository.save(u);
//        a = new Address();
//        a.setAddress1("951 Stanley Ct, Erie, CO 80516");
//        a = addressRepository.save(a);
//        UUID addressId2 = a.getId();
//        System.out.println("address2 id = "+addressId2);
//        System.out.println("user id = "+u.getId());
//        Restaurant r = new Restaurant();
//        r.setAddress(a);
//        r.setName("Mom and Renee's Place");
//        r = restaurantRepository.save(r);
//        Menu m = new Menu();
//        m.setName("M&R Dinner");
//        m.setRestaurant(r);
//        m = menuRepository.save(m);
//        Set<MenuItem> menuItems = new HashSet<>();
//        MenuItem item = new MenuItem();
//        item.setMenu(m);
//        item.setName("Turkey");
//        item.setPrice(1000L);
//        item = menuItemRepository.save(item);
//        item = new MenuItem();
//        menuItems.add(item);
//        item.setMenu(m);
//        item.setName("Sweet Potatoes");
//        item.setPrice(500L);
//        item = menuItemRepository.save(item);
//        menuItems.add(item);
//        item = new MenuItem();
//        item.setMenu(m);
//        item.setName("Spinach");
//        item.setPrice(500L);
//        item = menuItemRepository.save(item);
//        menuItems.add(item);
//        item = new MenuItem();
//        item.setMenu(m);
//        item.setName("Stuffing");
//        item.setPrice(300L);
//        item = menuItemRepository.save(item);
//        menuItems.add(item);
//        item = new MenuItem();
//        item.setMenu(m);
//        item.setName("Gravy");
//        item.setPrice(200L);
//        item = menuItemRepository.save(item);
//        menuItems.add(item);
//        item = new MenuItem();
//        item.setMenu(m);
//        item.setName("Date Nut Desert");
//        item.setPrice(300L);
//        item = menuItemRepository.save(item);
    }

    public String getTimeToDeliver(OrderRequest request) {
        String time="0:00:00";
        try {
            restTemplate = new RestTemplate();
            String userId = request.getUser();
            System.out.println("userId="+userId);
            UUID id = UUID.fromString(userId);
//            Iterable<User> users = userRepository.findAll();
//            users.forEach(user -> {
//                System.out.println("from DB: user="+user.getId());
//            });
            Optional<User> userOptional = userRepository.findById(id);
            Address userAddress = userOptional.isPresent() ? userOptional.get().getAddress() : null;
            Optional<Address> addressOptional = userAddress != null ? addressRepository.findById(userAddress.getId()) : Optional.empty();
            String address2 = addressOptional.isPresent() ? addressOptional.get().getAddress1() : "";
            System.out.println("address2="+address2);
            if (address2.isEmpty()) address2 = "15193 W 63rd Ave,Arvada,CO 80403";
            String restaurantId = request.getRestaurant();
            System.out.println("restaurantId="+restaurantId);
            id = UUID.fromString(restaurantId);
            Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
            Restaurant restaurant = restaurantOptional.isPresent() ? restaurantOptional.get() : null;
            Address restAddress = restaurant != null ? restaurant.getAddress() : null;
            addressOptional = restAddress != null ? addressRepository.findById(restAddress.getId()) : Optional.empty();
            String address1 = addressOptional.isPresent() ? addressOptional.get().getAddress1() : "";
            System.out.println("address1="+address1);
            String url = routeUrl+"?key="+consumerKey+"&from="+address1+"&to="+address2;
            // call mapquest REST endpoint for route
            ResponseEntity<Route> responseEntity = restTemplate.getForEntity(url, Route.class);
            if (responseEntity.getStatusCode()== HttpStatus.OK) {
                time = responseEntity.getBody().getFormattedTime();
            } else {
                time = "no time";
            }
        } catch (Exception e1) {
            System.out.println("exception encountered: "+e1.getMessage());
            e1.printStackTrace();
        }
        return time;
    }

}
