package com.jalbersh.sample.repository;

import com.jalbersh.sample.model.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MenuRepository extends CrudRepository<Menu, UUID> {
    Menu findByRestaurant(UUID restaurantID);
}
