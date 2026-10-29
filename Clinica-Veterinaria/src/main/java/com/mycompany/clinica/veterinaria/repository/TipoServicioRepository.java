/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.veterinaria.repository;
import com.mycompany.clinica.veterinaria.domain.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author brene
 */
public interface TipoServicioRepository  extends JpaRepository<TipoServicio, Integer> {
    
}
