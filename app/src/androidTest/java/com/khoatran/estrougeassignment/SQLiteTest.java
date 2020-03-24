package com.khoatran.estrougeassignment;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.khoatran.estrougeassignment.common.Constants;
import com.khoatran.estrougeassignment.db.DataBaseManager;
import com.khoatran.estrougeassignment.model.City;
import com.khoatran.estrougeassignment.presenter.IMainActivityPresenter;
import com.khoatran.estrougeassignment.presenter.MainActivityPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SQLiteTest {
    private DataBaseManager mDataSource;

    @Before
    public void setUp(){
        mDataSource = new DataBaseManager(InstrumentationRegistry.getTargetContext());
    }

    @Test
    public void testTotalRecords() {

        int numberOfRecords = mDataSource.getCount();
        assertEquals(272128, numberOfRecords);
    }

    @After
    public void finish() {
        mDataSource.close();
    }

}
