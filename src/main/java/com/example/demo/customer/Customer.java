package com.example.demo.customer;

import java.time.LocalDate;

public class Customer {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String telephoneNumber;
    private String email;

    public Customer(String name, String surname, LocalDate birthDate, String telephoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
