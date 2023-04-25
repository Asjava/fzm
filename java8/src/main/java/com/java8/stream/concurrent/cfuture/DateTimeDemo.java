package com.java8.stream.concurrent.cfuture;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2022-11-7 16:24
 * Company: 厦门船顺科技有限公司
 *
 * @author: fuzhm
 */
public class DateTimeDemo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2014, 1, 29);
        LocalTime time = LocalTime.of(13, 10, 29);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);
        System.out.println(LocalDate.now());

        System.out.println(date.get(ChronoField.YEAR));

        System.out.println(LocalTime.now());

//        LocalTime.parse(DateTimeFormatter.ISO_INSTANT.format());
        LocalDateTime dt0 = LocalDateTime.of(2014, 1, 29, 13, 10, 29);
        LocalDateTime dt1 = date.atTime(time);
        LocalDateTime dt2 = time.atDate(date);

        LocalDate localDate = dt0.toLocalDate();
        LocalTime time1 = dt0.toLocalTime();
        System.out.println(localDate);
        System.out.println(time1);

    }
}
