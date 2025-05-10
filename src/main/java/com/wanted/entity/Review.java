
package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "review")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 리뷰 ID
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;        // 상품 ID (FK)
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;              // 사용자 ID (FK)
    
    private Integer rating;         // 평점 (1-5)
    private String title;           // 제목
    private String content;         // 내용

    @CreatedDate
    private LocalDateTime createdAt; // 작성일

    @LastModifiedDate
    private LocalDateTime updatedAt; // 수정일
    private Boolean verifiedPurchase; // 구매 확인 여부
    private Integer helpfulVotes;   // 도움됨 투표 수

    public void setProduct(Product product) {
        this.product = product;
        if (product != null && !product.getReviews().contains(this)) {
            product.getReviews().add(this);
        }
    }
}
