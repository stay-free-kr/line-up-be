package com.example.lineupbetmp.auth.service;

import com.example.lineupbetmp.auth.dto.LoginRequest;
import com.example.lineupbetmp.auth.dto.LoginResponse;
import com.example.lineupbetmp.auth.dto.SignupRequest;
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
            throw new IllegalArgumentException("이미 존재하는 사용자명입니다.");
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
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtUtil.generateToken(user.getUserId(), user.getUserName());
        return LoginResponse.of(token, user.getUserId(), user.getUserName());
    }
}
