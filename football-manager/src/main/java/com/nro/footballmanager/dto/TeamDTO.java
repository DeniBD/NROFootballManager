package com.nro.footballmanager.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nro.footballmanager.entity.Game;
import com.nro.footballmanager.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO implements Comparable<TeamDTO>{
    private Long id;
    private String name;
    private int goalsScored;
    private int goalsReceived;
    private int victories;
    private int defeats;
    private int draws;

    @Override
    public int compareTo(TeamDTO o) {
        int points1 = this.victories * 3 + this.draws;
        int points2 = o.victories * 3 + o.draws;

        int goals1 = this.goalsScored - this.goalsReceived;
        int goals2 = o.goalsScored - o.goalsReceived;

        if (points1 == points2) {
            if (goals1 == goals2) {
                return o.goalsScored - this.goalsScored;
            }
            return goals2 - goals1;
        }
        return points2 - points1;
    }
}
