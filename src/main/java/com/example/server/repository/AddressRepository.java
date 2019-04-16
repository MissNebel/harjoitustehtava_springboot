package com.example.server.repository;

import com.example.server.model.CompanyAddress;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<CompanyAddress, Integer> {
}
