/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.veterinaria.controllers;


import com.mycompany.clinica.veterinaria.service.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author brene
 */
@Controller
@RequestMapping("/citas")
public class CitaController {
     private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/listado")
    public String mostrarCitas(Model model) {
        model.addAttribute("listaCitas", citaService.listarCitasProgramadas());
        return "citas/listado";
    }
}
