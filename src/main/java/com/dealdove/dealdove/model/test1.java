package com.dealdove.dealdove.model;

import java.time.ZonedDateTime;

public class test1 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime.getZone());
        System.out.println(zonedDateTime.getDayOfMonth());
    }
}
