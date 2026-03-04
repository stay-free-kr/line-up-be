package com.example.lineupbetmp.auth.service;

import com.example.lineupbetmp.auth.dto.LoginRequest;
import com.example.lineupbetmp.auth.dto.LoginResponse;
import com.example.lineupbetmp.auth.dto.SignupRequest;
import com.example.lineupbetmp.common.exception.BusinessException;
import com.example.lineupbetmp.common.exception.ErrorCode;
import com.example.lineupbetmp.config.JwtUtil;
import com.example.lineupbetmp.entity.User;
import com.example.lineupbetmp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public LoginResponse signup(SignupRequest request) {
        if (userRepository.existsByUserName(request.userName())) {
            throw new BusinessException(ErrorCode.DUPLICATE_USERNAME);
        }

        User user = User.builder()
                .userName(request.userName())
                .password(passwordEncoder.encode(request.password()))
                .phoneNum(request.phoneNum())
                .build();

        User savedUser = userRepository.save(user);
        String token = jwtUtil.generateToken(savedUser.getUserId(), savedUser.getUserName());

        return LoginResponse.of(token, savedUser.getUserId(), savedUser.getUserName());
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUserName(request.userName())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BusinessException(ErrorCode.INVALID_PASSWORD);
        }

        String token = jwtUtil.generateToken(user.getUserId(), user.getUserName());
        return LoginResponse.of(token, user.getUserId(), user.getUserName());
    }
}
