package com.dh.hibernate.aula33.repository;

import com.dh.hibernate.aula33.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Integer> {
}
