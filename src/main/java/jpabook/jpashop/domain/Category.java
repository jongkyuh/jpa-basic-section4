package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(fetch =FetchType.LAZY )
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent") // 기본이 Lazy 
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<Item> items = new ArrayList<>();
}
