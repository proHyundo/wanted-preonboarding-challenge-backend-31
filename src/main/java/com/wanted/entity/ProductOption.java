package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product_option")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 옵션 ID
    
    @ManyToOne
    @JoinColumn(name = "option_group_id")
    private ProductOptionGroup optionGroup; // 옵션 그룹 ID (FK)
    
    private String name;            // 옵션명 (예: "빨강", "XL")
    private BigDecimal additionalPrice; // 추가 가격
    private String sku;             // 재고 관리 코드
    private Integer stock;          // 재고 수량
    private Integer displayOrder;   // 표시 순서

    public void setOptionGroup(ProductOptionGroup optionGroup) {
        this.optionGroup = optionGroup;
        if (optionGroup != null && !optionGroup.getOptions().contains(this)) {
            optionGroup.getOptions().add(this);
        }
    }
}
