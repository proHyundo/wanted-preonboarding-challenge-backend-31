package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "seller")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 판매자 ID
    
    private String name;            // 판매자명
    private String description;     // 설명
    private String logoUrl;         // 로고 이미지 URL
    private Double rating;          // 평점
    private String contactEmail;    // 연락처 이메일
    private String contactPhone;    // 연락처 전화번호
    @CreatedDate
    private LocalDateTime createdAt; // 등록일
    @LastModifiedDate
    private LocalDateTime updatedAt; // 수정일
}
