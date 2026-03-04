package com.example.lineupbetmp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CHAT_ROOM")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAT_ROOM_ID")
    private Integer chatRoomId;

    @Column(name = "MISSION_ID", nullable = false)
    private Integer missionId;

    @Column(name = "ROOM_TYPE_CODE")
    private String roomTypeCode;
}
