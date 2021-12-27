package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HzService {

    public HzService() {
    }

    public boolean checkPassword(String password)
    {
        String pattren = ".+";
        return password.matches(pattren);
    }
}
