package com.example.herencia.repository;

import com.example.herencia.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEntityRespository extends JpaRepository <BaseEntity, Long> {
}
