package com.applet.config;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author LuckyCurve
 * @date 2020/5/15 23:10
 */
public class DateConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String s) {
        if ("".equals(s)) {
            return null;
        }

        LocalDate parse = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return parse.atStartOfDay();
    }
}
