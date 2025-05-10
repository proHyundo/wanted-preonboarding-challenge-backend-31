package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_option_group")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 옵션 그룹 ID
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;        // 상품 ID (FK)
    
    private String name;            // 옵션 그룹명 (예: "색상", "사이즈")
    private Integer displayOrder;   // 표시 순서
    
    @OneToMany(mappedBy = "optionGroup", cascade = CascadeType.ALL)
    private List<ProductOption> options = new ArrayList<>();

    public void setProduct(Product product) {
        this.product = product;
        if (product != null && !product.getOptionGroups().contains(this)) {
            product.getOptionGroups().add(this);
        }
    }
}
