package com.znsd.sportscenterweb.Utils;

import java.util.UUID;

public class Uuid {

    public static String getId() {

        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();//015ef458-d274-4ac2-a32d-19cc9c079631
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);//015ef458d2744ac2a32d19cc9c079631
        return temp;
    }

}
