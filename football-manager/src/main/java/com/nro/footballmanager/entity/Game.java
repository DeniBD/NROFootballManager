package com.nro.footballmanager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_one_id", referencedColumnName = "id")
    private Team teamOne;

    @ManyToOne
    @JoinColumn(name = "team_two_id", referencedColumnName = "id")
    private Team teamTwo;

    @Column
    private LocalTime startHour;

    @Column
    private Date date;

    @OneToOne
    @JoinColumn(name = "result_id", referencedColumnName = "id")
    private Result result;

    @ManyToOne
    @JoinColumn(name = "stadium_id", referencedColumnName = "id")
    private Stadium stadium;

}
