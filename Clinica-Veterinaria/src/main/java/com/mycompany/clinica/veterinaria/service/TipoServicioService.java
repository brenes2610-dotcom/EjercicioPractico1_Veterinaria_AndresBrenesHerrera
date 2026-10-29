/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.clinica.veterinaria.service;

import com.mycompany.clinica.veterinaria.domain.TipoServicio;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author brene
 */
public interface TipoServicioService {

    List<TipoServicio> listarTipos();

    Optional<TipoServicio> buscarTipoPorId(Integer id);

    void guardarTipo(TipoServicio tipo);

    void eliminarTipo(Integer id);
}
