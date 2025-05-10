package com.wanted.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 카테고리 ID
    
    private String name;            // 카테고리명
    private String slug;            // URL 슬러그
    private String description;     // 설명
    
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;        // 상위 카테고리 ID (FK, 자기참조)
    
    @OneToMany(mappedBy = "parent")
    private List<Category> children = new ArrayList<>(); // 하위 카테고리 목록
    
    private Integer level;          // 카테고리 레벨 (1: 대분류, 2: 중분류, 3: 소분류)
    private String imageUrl;        // 카테고리 이미지
}
