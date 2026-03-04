package com.example.lineupbetmp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "PHONE_NUM", nullable = false)
    private String phoneNum;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}
