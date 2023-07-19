package com.nro.footballmanager.dto;

import com.nro.footballmanager.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StadiumDTO {
    private Long id;
    private String name;
    private String location;
}
