package com.example.lineupbetmp.auth.dto;

public record SignupRequest(
        String userName,
        String password,
        String phoneNum
) {}
