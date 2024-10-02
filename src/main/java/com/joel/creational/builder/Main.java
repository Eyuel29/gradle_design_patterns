package com.joel.creational.builder;
import com.joel.creational.builder.HttpRequest;

public class Main {
    public static void main(String[] args) {        
        HttpRequest httpRequest = new HttpRequest.Builder()
        .setMethod(HttpRequest.HttpMethods.GET)
        .addHeader("content-type", "application/json")
        .setContentLength(20000)
        .setBody("{\"name\" : \"Eyuel\"}")
        .addCookie("session", "asasldklkjhasdlkfhasldkfhlkoiueryowtyweiorhklsdiweorit")
        .build();                
        System.out.println(httpRequest.getHeaders());
    }    
}
