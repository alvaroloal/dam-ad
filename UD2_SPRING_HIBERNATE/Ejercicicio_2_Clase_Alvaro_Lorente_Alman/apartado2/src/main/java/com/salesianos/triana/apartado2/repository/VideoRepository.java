package com.salesianos.triana.apartado2.repository;

import com.salesianos.triana.apartado2.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository <Video, Long> {
}
