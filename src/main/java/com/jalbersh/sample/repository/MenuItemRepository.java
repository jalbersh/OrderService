package com.jalbersh.sample.repository;

import com.jalbersh.sample.model.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MenuItemRepository extends CrudRepository<MenuItem, UUID> {
}
