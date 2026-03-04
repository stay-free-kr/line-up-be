package com.example.lineupbetmp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MISSION_APPLICATION")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MissionApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MISSION_APPLICATION_ID")
    private Integer missionApplicationId;

    @Column(name = "APPLICANT_USER_ID")
    private String applicantUserId;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "APPLICATION_STATUS_CODE")
    private String applicationStatusCode;

    @Column(name = "MISSION_ID")
    private Integer missionId;
}
