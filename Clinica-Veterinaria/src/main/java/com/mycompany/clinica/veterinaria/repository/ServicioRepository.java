/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.veterinaria.repository;
import com.mycompany.clinica.veterinaria.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author brene
 */
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    
}
