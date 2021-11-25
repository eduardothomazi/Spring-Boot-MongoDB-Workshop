package com.eduardo.workshopmongodb.resources.util;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public static String decodeParam(String text){
        try {
            return URLDecoder.decode(text, "UTF8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
    public static Date convertDate(String textDate, Date defaultValue){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));//using GMT pattern, but it depends on if is needed to use other
        try{
            return sdf.parse(textDate);
        }
        catch (ParseException e){
            return defaultValue;
        }
    }
}
