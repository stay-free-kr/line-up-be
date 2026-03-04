package com.example.lineupbetmp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CODE_INFO")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CodeInfo {

    @Id
    @Column(name = "CODE_INFO_ID")
    private String codeInfoId;

    @Column(name = "GROUP_ID", nullable = false)
    private String groupId;

    @Column(name = "CODE_ID", nullable = false)
    private String codeId;

    @Column(name = "CODE_NM")
    private String codeNm;

    @Column(name = "GROUP_DESC")
    private String groupDesc;

    @Column(name = "CODE_DESC")
    private String codeDesc;
}
