/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.veterinaria.repository;
import com.mycompany.clinica.veterinaria.domain.Cita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author brene
 */
public interface CitaRepository extends JpaRepository<Cita, Integer>{
    List<Cita> findAllByOrderByFechaAsc();
}
