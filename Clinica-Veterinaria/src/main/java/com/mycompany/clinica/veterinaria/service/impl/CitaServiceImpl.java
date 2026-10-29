/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.veterinaria.service.impl;

import com.mycompany.clinica.veterinaria.domain.Cita;
import com.mycompany.clinica.veterinaria.repository.CitaRepository;
import com.mycompany.clinica.veterinaria.service.CitaService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author brene
 */
@Service
public class CitaServiceImpl implements CitaService{
     private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cita> listarCitasProgramadas() {
        return citaRepository.findAllByOrderByFechaAsc();
    }
}
