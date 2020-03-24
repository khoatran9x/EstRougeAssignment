package com.khoatran.estrougeassignment.presenter;

import com.khoatran.estrougeassignment.model.City;
import com.khoatran.estrougeassignment.model.CityModel;
import com.khoatran.estrougeassignment.model.ICityModel;
import com.khoatran.estrougeassignment.view.main.IMainActivityView;

import java.util.ArrayList;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public class MainActivityPresenter implements IMainActivityPresenter {
    private IMainActivityView iMainActivityView;
    private ICityModel iCityModel;

    public MainActivityPresenter(IMainActivityView iMainActivityView) {
        this.iMainActivityView = iMainActivityView;
        iCityModel = new CityModel(iMainActivityView);
    }

    @Override
    public void setDataToRecyclerview(int limitRow, int offset) {
        ArrayList<City> cities = iCityModel.getListCityFromDatabaseWithPaging(limitRow, offset);
        iMainActivityView.setDataToRecyclerview(cities);
    }
}