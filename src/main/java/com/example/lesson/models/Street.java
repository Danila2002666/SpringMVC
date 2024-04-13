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
@Table(name = "street")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "streetId", cascade = CascadeType.ALL)
    private List<Apartment> apartments = new ArrayList<>();

    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apartments=" + apartments +
                '}';
    }
}
