package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "brand")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 브랜드 ID
    
    private String name;            // 브랜드명
    private String slug;            // URL 슬러그
    private String description;     // 설명
    private String logoUrl;         // 로고 이미지 URL
    private String website;         // 웹사이트 URL
}