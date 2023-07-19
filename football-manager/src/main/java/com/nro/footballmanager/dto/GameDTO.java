package com.nro.footballmanager.dto;

import com.nro.footballmanager.entity.Result;
import com.nro.footballmanager.entity.Stadium;
import com.nro.footballmanager.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameDTO {
    private Long id;
    private TeamDTO teamOne;
    private TeamDTO teamTwo;
    private LocalTime startHour;
    private Date date;
    private ResultDTO result;
    private StadiumDTO stadium;
}
