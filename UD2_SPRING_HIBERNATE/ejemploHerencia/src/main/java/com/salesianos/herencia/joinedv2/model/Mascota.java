package com.salesianos.herencia.joinedv2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@PrimaryKeyJoinColumn(name = "mascotaId")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mascota extends Animal {
    private String name;


}
