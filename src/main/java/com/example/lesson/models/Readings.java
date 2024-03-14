package com.example.lesson.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name = "readings")
public class Readings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counter_id")
    private Meters meters;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private BigDecimal value;
}
