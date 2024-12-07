package com.example.fpisfondrum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wine")
@Getter
@Setter
@NoArgsConstructor
public class Wine {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name = "wine_style_id")
    private WineStyle style;

    @ManyToOne
    @JoinColumn(name = "wine_variety_id")
    private WineVariety variety;

    public Wine(String name, WineStyle style, WineVariety variety) {
        this.name = name;
        this.style = style;
        this.variety = variety;
    }
}
