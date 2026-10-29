/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.veterinaria.service;

import com.mycompany.clinica.veterinaria.domain.Servicio;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author brene
 */
public interface ServicioService {
    
    List<Servicio> listarServicios();

    Optional<Servicio> buscarServicioPorId(Integer id);

    void guardarServicio(Servicio servicio);

    void eliminarServicio(Integer id);
}
