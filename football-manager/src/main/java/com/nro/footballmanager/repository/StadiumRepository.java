package com.nro.footballmanager.repository;

import com.nro.footballmanager.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
