package com.example.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.server.model.CompanyAddress;
import com.example.server.model.Company;
import com.example.server.repository.CompanyRepository;
import com.example.server.repository.AddressRepository;
import com.example.server.model.User;

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

    @GetMapping("/companies/validateLogin")

    public User validateLogin() {
        return new User("User successfully authenticated");
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteCompany(@PathVariable int id) {
        Company a = repository.getOne(id);
        deleteAddress(id);
        repository.delete(a);

        return HttpStatus.OK;
    }

    @DeleteMapping("/deleteaddress/{id}")
    public HttpStatus deleteAddress(@PathVariable int id) {
        CompanyAddress a = arepository.getOne(id);
        arepository.delete(a);

        return HttpStatus.OK;
    }



}