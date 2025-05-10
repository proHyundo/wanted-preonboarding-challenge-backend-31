package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_tag")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 매핑 ID
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;        // 상품 ID (FK)
    
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;                // 태그 ID (FK)

    public void setProduct(Product product) {
        this.product = product;
        if (product != null && !product.getTags().contains(this)) {
            product.getTags().add(this);
        }
    }

    public void setTag(Tag tag) {
        this.tag = tag;
        if (tag != null && tag.getProductTags() != null && !tag.getProductTags().contains(this)) {
            tag.getProductTags().add(this);
        }
    }

}
