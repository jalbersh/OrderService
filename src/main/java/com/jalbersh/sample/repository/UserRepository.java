package com.jalbersh.sample.repository;

import com.jalbersh.sample.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
