package com.example.server.model;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity                             //Entity-luokka, että täällä olevat asiat voidaan tallentaa tietokantaan

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne
    @JoinColumn
    @MapsId
    private CompanyAddress address;


   public Company(){}

   public Company(String name, CompanyAddress address) {
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public CompanyAddress getAddress() {
       return this.address;
    }

    @Override
    public String toString() {
        return "Company [id=" + id + ", name=" + name + ", address=" + address +"]";

    }


}
