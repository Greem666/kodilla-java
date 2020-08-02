package com.kodilla.hibernate.manytomany.facade;

public class CompanyDto {
    private int id;
    private String name;

    public CompanyDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
