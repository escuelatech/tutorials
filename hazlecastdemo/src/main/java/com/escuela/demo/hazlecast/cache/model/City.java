package com.escuela.demo.hazlecast.cache.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

//@
public class City implements Serializable {

    @Id
    private String name;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("\"")
                .append(name)
                .append(", ")
                .append(country)
                .append("\"")
                .toString();
    }
}
