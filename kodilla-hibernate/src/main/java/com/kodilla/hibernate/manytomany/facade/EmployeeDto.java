package com.kodilla.hibernate.manytomany.facade;

public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;

    public EmployeeDto(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
