package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HzService {

    public HzService() {
    }

    public boolean checkPassword(String password)
    {
        String pattren = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(pattren);
    }
}
