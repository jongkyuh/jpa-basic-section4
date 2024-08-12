package jpabook.jpashop.domain;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    private String createdBy;
    private String lastModifiedBy;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
