package com.nro.footballmanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;

import java.util.List;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private int goalsScored;

    @Column
    private int goalsReceived;

    @Column
    private int victories;

    @Column
    private int defeats;

    @Column
    private int draws;

    @OneToMany(mappedBy = "team")
    private List<Player> players;

    @OneToMany(mappedBy = "teamOne")
    private List<Game> gamesTeamOne;

    @OneToMany(mappedBy = "teamTwo")
    private List<Game> gamesTeamTwo;


//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }

}
