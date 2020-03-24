package com.khoatran.estrougeassignment.common;

import android.Manifest;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public class Constants {
    // SharePreferences
    public static final String SHARED_PREFERENCES_FILE_NAME = "ASSIGNMENT_KHOATRAN_PREFERENCES_FILE";


    public static final String BLANK = "";
    public static final String PROCESSING = "Processing...";

    public static final int DELAY_TIME = 1000;

    // Toast duration
    public static final int TOAST_DURATION_SHORT = 0;
    public static final int TOAST_DURATION_LONG = 1;
    public static final int TOAST_SUCCESS_TYPE = 0;
    public static final int TOAST_FAIL_TYPE = 1;

    // Limit & offset for paging
    public static final int LIMIT = 100;
    public static final int OFFSET = 0;

    //Permission Code
    public static final int READ_STORAGE_PERMISSION = 1990;
    public static final String READ_STORAGE_PERMISSION_STRING = Manifest.permission.READ_EXTERNAL_STORAGE;


    // Define default Width and Height of screen
    public static final int DEFAULT_SCREEN_WIDTH = 360;
    public static final int DEFAULT_SCREEN_HEIGHT = 640;
}
