package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_category")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 매핑 ID
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;        // 상품 ID (FK)
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;      // 카테고리 ID (FK)
    
    private Boolean isPrimary;      // 주요 카테고리 여부

    public void setProduct(Product product) {
        this.product = product;
        if (product != null && !product.getCategories().contains(this)) {
            product.getCategories().add(this);
        }
    }

    public void setCategory(Category category) {
        this.category = category;
        // 카테고리 쪽에도 이 매핑을 추가하는 로직이 있다면 필요
    }
}
