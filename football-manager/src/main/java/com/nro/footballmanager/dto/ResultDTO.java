package com.nro.footballmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    private Long id;
    private int goalsTeamOne;
    private int goalsTeamTwo;
}
