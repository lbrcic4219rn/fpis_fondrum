package com.example.fpisfondrum.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "wine_order")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Wine> wines;

    public Order(List<Wine> wines) {
        this.wines = wines;
    }
}
