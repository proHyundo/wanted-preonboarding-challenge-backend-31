package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")  // 'user'는 PostgreSQL의 예약어이므로 'users'로 변경
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 사용자 ID
    
    private String username;        // 사용자명
    private String email;           // 이메일
    // 필요에 따라 다른 사용자 정보 추가
}