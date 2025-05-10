package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@Table(name = "product_detail")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 상세 ID

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;        // 상품 ID (FK)

    private Double weight;          // 무게
    
    @Column(columnDefinition = "jsonb")
    private String dimensions;      // 크기 (JSON)
    
    private String materials;       // 소재 정보
    private String countryOfOrigin; // 원산지
    private String warrantyInfo;    // 보증 정보
    private String careInstructions; // 관리 지침
    
    @Column(columnDefinition = "jsonb")
    private String additionalInfo;  // 추가 정보 (JSONB)
}
