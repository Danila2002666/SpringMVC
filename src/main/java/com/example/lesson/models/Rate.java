package com.example.lesson.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "rate", cascade = CascadeType.DETACH)
    private List<Apartment> apartment = new ArrayList<>();

    @Column(name = "price_cold_water")
    private BigDecimal priceCold;

    @Column(name = "price_warm_water")
    private BigDecimal priceWarm;

}
