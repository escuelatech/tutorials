package com.escuela.demo.hazlecast.cache.model;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigInteger;

@QueryEntity
public class City implements Serializable,Comparable {

    @Id
    private String name;
    private String country;

    private BigInteger min;
    private BigInteger max;

    public BigInteger getMax() {
        return max;
    }

    public City setMax(BigInteger max) {
        this.max = max;
        return this;
    }

    public BigInteger getMin() {
        return min;
    }

    public City setMin(BigInteger min) {
        this.min = min;
        return this;
    }



    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public City setCountry(String country) {
        this.country = country;
        return this;
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

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
