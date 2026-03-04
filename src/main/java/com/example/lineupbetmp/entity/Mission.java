package com.example.lineupbetmp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "MISSION")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MISSION_ID")
    private Integer missionId;

    @Column(name = "MISSION_STATUS_CODE", nullable = false)
    private String missionStatusCode;

    @Column(name = "TAG_CODE")
    private String tagCode;

    @Column(name = "OWNER_USER_ID", nullable = false)
    private Integer ownerUserId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "APPOINT_DT")
    private LocalDateTime appointDt;

    @Column(name = "BASE_ADDRESS")
    private String baseAddress;

    @Column(name = "DETAIL_ADDRESS")
    private String detailAddress;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "PRICE")
    private Integer price;

    @Column(name = "MAX_APPLICANT_NUM")
    private Integer maxApplicantNum;
}
