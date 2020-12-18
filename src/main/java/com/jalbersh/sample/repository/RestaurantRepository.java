package com.jalbersh.sample.repository;

import com.jalbersh.sample.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RestaurantRepository extends CrudRepository<Restaurant, UUID> {
}
