/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.veterinaria.service.impl;

import com.mycompany.clinica.veterinaria.domain.TipoServicio;
import com.mycompany.clinica.veterinaria.repository.TipoServicioRepository;
import com.mycompany.clinica.veterinaria.service.TipoServicioService;
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
public class TipoServicioServiceImpl  implements TipoServicioService{
    
    private final TipoServicioRepository tipoServicioRepository;

    public TipoServicioServiceImpl(TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoServicio> listarTipos() {
        return tipoServicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoServicio> buscarTipoPorId(Integer id) {
        return tipoServicioRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardarTipo(TipoServicio tipo) {
        tipoServicioRepository.save(tipo);
    }

    @Override
    @Transactional
    public void eliminarTipo(Integer id) {
        if (!tipoServicioRepository.existsById(id)) {
            throw new IllegalArgumentException("El tipo de servicio con id " + id + " no existe");
        }
        try {
            tipoServicioRepository.deleteById(id);
            tipoServicioRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar: el tipo tiene servicios asociados", e);
        }
    }
}
