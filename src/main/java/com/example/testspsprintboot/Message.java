package com.example.testspsprintboot;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Message {
    @JsonProperty("date")
    public Date date;
    @JsonProperty("message")
    public String message;
    @JsonProperty("house")
    public String house;

    public void print() {

    }
}
