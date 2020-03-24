package com.khoatran.estrougeassignment.utils;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public class Utils {

    /**
     * @author Khoa Tran Anh
     *
     * format number and convert to String
     * @param number
     * @return String
     */
    public static String numberFormatter(Integer number){
        String formatter = "";
        if(number != null){
            if(number > 0){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("#");
                stringBuilder.append(",");
                stringBuilder.append("###");
                DecimalFormat dFormat = new DecimalFormat(stringBuilder.toString());
                formatter = dFormat.format(number);
            }
        }
        return formatter;
    }

    /**
     * @author Khoa Tran Anh
     *
     * check database file is existing or not
     * @param assetManager
     * @param filePath
     * @return boolean
     */
    public static boolean isDBFileExists(AssetManager assetManager, String filePath)  {
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open(filePath);
            return true;
        }  catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
