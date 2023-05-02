package com.example.demo.entity;

import com.example.demo.listeners.ProductCounterListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;

import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@EntityListeners(value = ProductCounterListener.class)
@Slf4j
public class Product {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long productId;

     @Column(name = "product_name", length = 20)
     private String name;

     @Column(name = "product_description")
     private String description;

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
          Product product = (Product) o;
          return getProductId() != null && Objects.equals(getProductId(), product.getProductId());
     }

     @Override
     public int hashCode() {
          return getClass().hashCode();
     }
}
