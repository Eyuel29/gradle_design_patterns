package com.joel.creational.factory;

import com.joel.creational.factory.CustomLogger;
import com.joel.creational.factory.CustomLoggerFactory;
import com.joel.creational.factory.CustomLoggerFactory.CustomLoggers;

public class Main{
    public static void main(String[] args){
        CustomLogger customLogger = new CustomLoggerFactory()
        .getLogger(CustomLoggers.CustomFileLogger);
        customLogger.log("some message");
    }
}