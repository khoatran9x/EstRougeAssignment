package com.khoatran.estrougeassignment.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.khoatran.estrougeassignment.R;
import com.khoatran.estrougeassignment.common.Constants;
import com.khoatran.estrougeassignment.db.DataBaseManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView{

    protected Context mCtx;
    private Unbinder mUnbinder;
    private ProgressDialog mProgressDialog;
    private AlertDialog mErrorDialog;
    private boolean doubleBackToExitPressedOnce = false;
    protected DataBaseManager mDb; // DB

    @CallSuper
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        mCtx = BaseActivity.this;
        mUnbinder = ButterKnife.bind(this);
        // db
        mDb = new DataBaseManager(mCtx);
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        // dismiss Progress Dialog
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }

        // dismiss Error Dialog
        if (mErrorDialog != null) {
            mErrorDialog.dismiss();
            mErrorDialog = null;
        }

        // close DB
        if (mDb != null) {
            mDb.close();
            mDb = null;
        }

        mUnbinder.unbind();
        super.onDestroy();
    }

    protected abstract int getLayoutResourceId();

    /** Hide the keyboard when touch outside */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public void showLoadingDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog = ProgressDialog.show(this, Constants.BLANK, Constants.PROCESSING, true, false);
        } else {
            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }
        }
    }

    @Override
    public void hideLoadingDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showErrorDialog(String errorMessage) {
        if (mErrorDialog == null) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setMessage(errorMessage)
                    .setCancelable(false)
                    .setOnCancelListener(DialogInterface::dismiss)
                    .setPositiveButton(R.string.ok, (dialog, which) -> {
                        dialog.dismiss();
                    });

            mErrorDialog = dialogBuilder.create();
        }

        if (!mErrorDialog.isShowing()) {
            mErrorDialog.setMessage(errorMessage);
            mErrorDialog.show();
        }
    }
}