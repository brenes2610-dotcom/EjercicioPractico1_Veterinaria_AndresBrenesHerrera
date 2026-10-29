/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.veterinaria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 *
 * @author brene
 */
@Data
@Entity
@Table(name = "cita")
public class Cita {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_mascota")
    private String nombreMascota;

    @Column(name = "nombre_propietario")
    private String nombrePropietario;

    @Column(name = "fecha")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Servicio servicio;
}
