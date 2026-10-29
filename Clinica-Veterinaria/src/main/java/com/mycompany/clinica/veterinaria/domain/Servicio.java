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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
/**
 *
 * @author brene
 */
@Data
@Entity
@Table(name = "servicio")
public class Servicio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede pasar de 100 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que cero")
    @Column(name = "precio")
    private BigDecimal precio;

    @NotNull(message = "La duración es obligatoria")
    @Min(value = 1, message = "La duración debe ser de al menos 1 minuto")
    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    @NotNull(message = "Debe seleccionar un tipo de servicio")
    @ManyToOne
    @JoinColumn(name = "tipo_servicio_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private TipoServicio tipoServicio; 
}
