package com.example.lineupbetmp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER_AUTH")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_AUTH_ID")
    private Integer userAuthId;

    @Column(name = "AUTH_NO")
    private String authNo;

    @Column(name = "AUTH_NO_DUE_DT")
    private LocalDateTime authNoDueDt;

    @Column(name = "USER_ID")
    private Integer userId;
}
