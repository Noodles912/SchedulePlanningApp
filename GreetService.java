package com.example.test;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class GreetService implements Serializable {

    public String greet(String name) {
        if (name == null || name.isEmpty()) {
            return "Your selections are not complete";
        } else {
            return "Here is your time table";
            
        }
    }
}
