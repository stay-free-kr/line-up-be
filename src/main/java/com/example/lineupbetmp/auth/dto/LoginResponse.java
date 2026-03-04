package com.example.lineupbetmp.auth.dto;

public record LoginResponse(
        String accessToken,
        String tokenType,
        Integer userId,
        String userName
) {
    public static LoginResponse of(String accessToken, Integer userId, String userName) {
        return new LoginResponse(accessToken, "Bearer", userId, userName);
    }
}
