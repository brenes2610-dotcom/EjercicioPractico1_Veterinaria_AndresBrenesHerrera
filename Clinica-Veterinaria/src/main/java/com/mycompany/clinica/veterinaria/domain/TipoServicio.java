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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 *
 * @author brene
 */
@Data
@Entity
@Table(name = "tipo_servicio")
public class TipoServicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede pasar de 100 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 255, message = "La descripción no puede pasar de 255 caracteres")
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tipoServicio")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Servicio> serviciosAsociados = new ArrayList<>();
}
