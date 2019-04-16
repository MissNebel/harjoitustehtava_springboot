package com.example.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.server.model.Company;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    //List<Company> findByName(String name);
}
