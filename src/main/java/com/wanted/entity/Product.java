package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 상품 ID

    private String name;            // 상품명
    private String slug;            // URL 슬러그 (SEO 최적화용)
    private String shortDescription; // 짧은 설명

    @Column(columnDefinition = "TEXT")
    private String fullDescription;  // 전체 설명 (HTML 허용)

    private LocalDateTime createdAt; // 등록일
    private LocalDateTime updatedAt; // 수정일

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;          // 판매자 ID (FK)

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;            // 브랜드 ID (FK)

    @Enumerated(EnumType.STRING)
    private ProductStatus status;   // 상태 (판매중, 품절, 삭제됨 등)

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductDetail productDetail;  // 상품 상세 정보

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductPrice> prices = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCategory> categories = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductOptionGroup> optionGroups = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductTag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    // 상품 상태 열거형
    public enum ProductStatus {
        IN_STOCK("판매중"),
        OUT_OF_STOCK("품절"),
        DELETED("삭제됨");

        private final String description;

        ProductStatus(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    // 상품 업데이트 메서드
    public void update(Product entity) {
        this.name = entity.getName();
        this.slug = entity.getSlug();
        this.shortDescription = entity.getShortDescription();
        this.fullDescription = entity.getFullDescription();
        this.updatedAt = LocalDateTime.now();
        this.status = entity.getStatus();
    }

    // 상품 옵션 그룹 추가 메서드
    public void addOptionGroup(ProductOptionGroup optionGroup) {
        this.optionGroups.add(optionGroup);
    }

    // 상품 이미지 추가 메서드
    public void addImage(ProductImage image) {
        this.images.add(image);
    }

    // 상품 카테고리 추가 메서드
    public void addCategory(ProductCategory category) {
        this.categories.add(category);
    }

    // 상품 태그 추가 메서드
    public void addTag(ProductTag tag) {
        this.tags.add(tag);
    }

    // 상품 리뷰 추가 메서드
    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
