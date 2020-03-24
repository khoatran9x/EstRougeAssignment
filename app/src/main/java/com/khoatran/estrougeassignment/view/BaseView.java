package com.khoatran.estrougeassignment.view;

import android.content.Context;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public interface BaseView {

    void showLoadingDialog();

    void hideLoadingDialog();

    void showErrorDialog(String errorMessage);

    Context context();
}
