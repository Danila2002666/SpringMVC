package com.example.lesson.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id")
    private Street streetId;

    @Column(name = "house_number")
    private int houseNumber;

    @Column(name = "apartment_number")
    private int apartmentNumber;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<Meters> meters = new ArrayList<>();
}