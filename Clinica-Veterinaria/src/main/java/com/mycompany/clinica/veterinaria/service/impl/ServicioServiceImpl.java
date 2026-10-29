/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.veterinaria.service.impl;
import com.mycompany.clinica.veterinaria.domain.Servicio;
import com.mycompany.clinica.veterinaria.repository.ServicioRepository;
import com.mycompany.clinica.veterinaria.service.ServicioService;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author brene
 */
@Service
public class ServicioServiceImpl implements ServicioService  {
     private final ServicioRepository servicioRepository;

    public ServicioServiceImpl(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Servicio> buscarServicioPorId(Integer id) {
        return servicioRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardarServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

    @Override
    @Transactional
    public void eliminarServicio(Integer id) {
        if (!servicioRepository.existsById(id)) {
            throw new IllegalArgumentException("El servicio con id " + id + " no existe");
        }
        try {
            servicioRepository.deleteById(id);
            servicioRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar: el servicio tiene citas asociadas", e);
        }
    }
}
