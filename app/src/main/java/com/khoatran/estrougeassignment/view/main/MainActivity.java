package com.khoatran.estrougeassignment.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.khoatran.estrougeassignment.R;
import com.khoatran.estrougeassignment.common.Constants;
import com.khoatran.estrougeassignment.model.City;
import com.khoatran.estrougeassignment.presenter.IMainActivityPresenter;
import com.khoatran.estrougeassignment.presenter.MainActivityPresenter;
import com.khoatran.estrougeassignment.view.BaseActivity;
import com.khoatran.estrougeassignment.view.splash.SplashActivity;
import com.khoatran.estrougeassignment.widget.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;

import static java.security.AccessController.getContext;

public class MainActivity extends BaseActivity implements IMainActivityView{

    @BindView(R.id.title_tv)
    TextView tvTitle;
    @BindView(R.id.list_city_rcv)
    RecyclerView rcvListCity;

    private boolean isLoadMore = false;
    private ListCityAdapter listCityAdapter;
    private IMainActivityPresenter iMainActivityPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        renderLayout();
        iMainActivityPresenter = new MainActivityPresenter(this);
        iMainActivityPresenter.setDataToRecyclerview(Constants.LIMIT, Constants.OFFSET);

    }

    // render layout for view
    private void renderLayout(){
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        rcvListCity.setLayoutManager(mLayoutManager);
        rcvListCity.setHasFixedSize(true);
        listCityAdapter = new ListCityAdapter(this);
        rcvListCity.setAdapter(listCityAdapter);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(this, R.drawable.divider)));
        rcvListCity.addItemDecoration(itemDecorator);

        // Handle loadmore items when scroll
        EndlessRecyclerViewScrollListener mRecyclerScrollListener = new EndlessRecyclerViewScrollListener(mLayoutManager) {
            @Override
            public void onLoadMore(int offset, int totalItemsCount, RecyclerView view) {
                isLoadMore = true;
                showLoadingDialog();
                new Handler().postDelayed(() -> {
                    iMainActivityPresenter.setDataToRecyclerview(Constants.LIMIT, offset);
                    hideLoadingDialog();
                }, Constants.DELAY_TIME);

            }
        };
        rcvListCity.addOnScrollListener(mRecyclerScrollListener);
    }


    @Override
    public void setDataToRecyclerview(ArrayList<City> cities) {
        if(isLoadMore) {
            listCityAdapter.addItemsToListCity(cities);
        } else {
            listCityAdapter.setListCity(cities);
        }
        listCityAdapter.notifyDataSetChanged();
    }

    @Override
    public Context context() {
        return this;
    }
}
