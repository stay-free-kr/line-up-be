package com.example.lineupbetmp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "CHAT_ROOM_MEMBER")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ChatRoomMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHAT_ROOM_MEMBER_ID")
    private Integer chatRoomMemberId;

    @Column(name = "CHAT_ROOM_ID", nullable = false)
    private Integer chatRoomId;

    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "ROLE_CODE")
    private String roleCode;

    @Column(name = "JOINED_AT")
    private LocalDateTime joinedAt;

    @Column(name = "LAST_READ_AT")
    private LocalDateTime lastReadAt;
}
