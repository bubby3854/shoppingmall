package com.example.goshopping.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long pNo;
    private String pName;
    private String pInfo;
    private String pPrice;
    private int pStock;
    private int pOrder;
    private LocalDateTime createdAt;
    
    @Builder
    public Product(String pName, String pInfo, String pPrice, int pStock, int pOrder) {
        this.pName = pName;
        this.pInfo = pInfo;
        this.pPrice = pPrice;
        this.pStock = pStock;
        this.pOrder = pOrder;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
