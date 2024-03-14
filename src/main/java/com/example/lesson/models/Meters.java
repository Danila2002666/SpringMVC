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
@Table(name = "meters")
public class Meters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "counter_number")
    private Long counterNumber;

    @Column(name = "type")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @OneToMany(mappedBy = "meters", cascade = CascadeType.ALL)
    private List<Readings> readings = new ArrayList<>();
}
