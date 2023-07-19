package com.nro.footballmanager.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nro.footballmanager.entity.Team;
import com.nro.footballmanager.entity.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class PlayerDTO implements Comparable<PlayerDTO>{
        private Long id;
        private String name;
        private int goalsScored;
        @JsonDeserialize(using = RoleEnumDeserializer.class)
        private RoleEnum role;
//        @JsonBackReference
        private TeamDTO team;

        public PlayerDTO(Long id, String name, int goalsScored, RoleEnum role, TeamDTO team) {
                this.id = id;
                this.name = name;
                this.goalsScored = goalsScored;
                this.role = role;
                this.team = team;
        }

        public PlayerDTO() {
        }

        public PlayerDTO(String name, int goalsScored, RoleEnum role, TeamDTO byName) {
                this.name = name;
                this.goalsScored = goalsScored;
                this.role = role;
                this.team = byName;
        }

        @Override
        public int compareTo(PlayerDTO o) {
                return this.team.getName().compareTo(o.getTeam().getName());
        }
}
