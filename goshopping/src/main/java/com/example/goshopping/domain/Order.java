package com.example.goshopping.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders") // "order"는 SQL 예약어이므로 "orders"로 테이블 이름 변경
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;
    private String address;
    private String paymentMethod;
    private String status = "결제 완료";

    @Builder
    public Order(User user, Product product, int quantity, String address, String paymentMethod, String status) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }
}

