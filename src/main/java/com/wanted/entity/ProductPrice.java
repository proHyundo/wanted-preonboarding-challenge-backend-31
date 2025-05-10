package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product_price")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 가격 ID

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;        // 상품 ID (FK)

    private BigDecimal basePrice;   // 기본 가격
    private BigDecimal salePrice;   // 할인 가격
    private BigDecimal costPrice;   // 원가 (관리용)
    
    @Column(columnDefinition = "varchar(3) default 'KRW'")
    private String currency;        // 통화 (기본값 KRW)
    
    private BigDecimal taxRate;     // 세율
}
