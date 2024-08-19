package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Embedded
   private Address address;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;


}
