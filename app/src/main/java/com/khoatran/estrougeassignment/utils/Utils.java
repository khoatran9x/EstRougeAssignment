package com.khoatran.estrougeassignment.utils;

import java.text.DecimalFormat;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public class Utils {
    public static String numberFormater(Integer number){
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
}
