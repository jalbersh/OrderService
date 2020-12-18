package com.jalbersh.sample.repository;

import com.jalbersh.sample.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID> {
    Optional<Address> findByAddress1(String address);
}
