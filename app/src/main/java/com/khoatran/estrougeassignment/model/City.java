package com.khoatran.estrougeassignment.model;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public class City {
    private String id;
    private String city;
    private String country;
    private Integer population;

    public City() {
    }

    public City(String id, String city, String country, Integer population) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
