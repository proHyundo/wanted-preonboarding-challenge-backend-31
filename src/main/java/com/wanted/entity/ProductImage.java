package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_image")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 이미지 ID
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;        // 상품 ID (FK)
    
    private String url;             // 이미지 URL
    private String altText;         // 대체 텍스트
    private Boolean isPrimary;      // 대표 이미지 여부
    private Integer displayOrder;   // 표시 순서
    
    @ManyToOne
    @JoinColumn(name = "option_id")
    private ProductOption option;   // 연관된 옵션 ID (FK, nullable)
}