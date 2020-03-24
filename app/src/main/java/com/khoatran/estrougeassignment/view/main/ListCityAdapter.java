package com.khoatran.estrougeassignment.view.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khoatran.estrougeassignment.R;
import com.khoatran.estrougeassignment.model.City;
import com.khoatran.estrougeassignment.utils.Utils;

import java.util.ArrayList;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public class ListCityAdapter extends RecyclerView.Adapter<ListCityAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<City> cities = new ArrayList<>();

    ListCityAdapter(Context context) {
        this.mContext = context;
    }

    public void setListCity(ArrayList<City> cities){
        this.cities.clear();
        if(cities != null){
            this.cities = cities;
        }
    }

    public void addItemsToListCity(ArrayList<City> cities){
        if(cities != null){
            this.cities.addAll(cities);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCountry;
        TextView tvCity;
        TextView tvPopulation;

        public ViewHolder(View view) {
            super(view);

            tvCountry = view.findViewById(R.id.country_tv);
            tvCity = view.findViewById(R.id.city_tv);
            tvPopulation = view.findViewById(R.id.population_tv);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_list_city, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") int position) {
        City city = this.cities.get(position);
        if (city != null){
            holder.tvCountry.setText(city.getCountry());
            holder.tvCity.setText(city.getCity());
            holder.tvPopulation.setText(Utils.numberFormater(city.getPopulation()));
        }
    }

    @Override
    public int getItemCount() {
        return this.cities == null ? 0 : this.cities.size();
    }
}