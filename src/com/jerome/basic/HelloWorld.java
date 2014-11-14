package com.jerome.basic;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("HelloWorld");
		System.out.println(~(10));
        Date date = new Date();
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.ssssss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern,
                Locale.getDefault());
        String timeString ="2014-11-05T12:16:52.449Z";
        try {
            Date date2 = sdf.parse(timeString);
            System.out.println(date2.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

	}
}
