package com.example.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.server.model.CompanyAddress;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import com.example.server.model.CompanyAddress;
import com.example.server.model.Company;

import com.example.server.repository.CompanyRepository;
import com.example.server.repository.AddressRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class CompanyController {

    @Autowired
    CompanyRepository repository;

    @Autowired
    AddressRepository arepository;

    @PostMapping("/add")
    public Company addCompany(@RequestBody Company company) { //@RequestBody että bäkkäri tietää lukea http-pyynnön bodyssa lähetettävän datan ja parsia sen automaattisesti
        arepository.save(company.getAddress());
        repository.save(company);
        return company;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return repository.findAll();
    }


    @DeleteMapping("/companies/{id}")
    public HttpStatus deleteCompany(@PathVariable int id) {
        Company a = repository.getOne(id);
        repository.delete(a);
        deleteAddress(id);

        return HttpStatus.OK;
    }

    @DeleteMapping("/companies/{id}")
    public HttpStatus deleteAddress(@PathVariable int id) {
        CompanyAddress a = arepository.getOne(id);
        arepository.delete(a);

        return HttpStatus.OK;
    }

   /* @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        System.out.println("Get all Companies...");

        List<Company> companies = new ArrayList<>();
        repository.findAll().forEach(companies);

        return companies;
    }

    @PostMapping(value = "/companies/add")
    public Company postCompany(@RequestBody String name) {

        Company a = new Company(name);
        Company _company = repository.save(a);
        return _company;
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") int id){
        System.out.println("Delete company with ID="  + id);

        repository.deleteById(id);

        return new ResponseEntity<>("Company deleted", HttpStatus.OK);
    } */

}