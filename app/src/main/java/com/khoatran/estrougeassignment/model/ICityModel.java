package com.khoatran.estrougeassignment.model;

import java.util.ArrayList;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public interface ICityModel {
    ArrayList<City> getListCityFromDatabase();
    ArrayList<City> getListCityFromDatabaseWithPaging(int limitRow, int offset);
}

