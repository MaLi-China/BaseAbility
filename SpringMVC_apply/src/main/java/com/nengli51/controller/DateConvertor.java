package com.nengli51.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class DateConvertor implements Converter<String, Date> {
    Date date = null;

    @Override
    public Date convert(String source) {
        if (source != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date = format.parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }
}