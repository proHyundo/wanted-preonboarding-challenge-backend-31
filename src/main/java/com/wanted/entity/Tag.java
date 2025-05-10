package com.wanted.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tag")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 태그 ID
    
    private String name;            // 태그명
    private String slug;            // URL 슬러그

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<ProductTag> productTags = new ArrayList<>(); // 상품-태그 매핑 리스트

    public void addProductTag(ProductTag productTag) {
        if (productTag != null && productTag.getTag() != this) {
            productTag.setTag(this);
        }
    }

}
