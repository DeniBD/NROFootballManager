package com.nro.footballmanager;

import com.nro.footballmanager.entity.Player;
import com.nro.footballmanager.entity.enums.RoleEnum;
import com.nro.footballmanager.service.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class })
public class FootballManagerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FootballManagerApplication.class, args);

    }

}

