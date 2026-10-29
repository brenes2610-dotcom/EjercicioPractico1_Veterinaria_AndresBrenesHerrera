/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.veterinaria.controllers;

import com.mycompany.clinica.veterinaria.domain.Servicio;
import com.mycompany.clinica.veterinaria.service.ServicioService;
import com.mycompany.clinica.veterinaria.service.TipoServicioService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author brene
 */
@Controller
@RequestMapping("/servicios")
public class ServicioController {
   
    private final ServicioService servicioService;
    private final TipoServicioService tipoServicioService;

    public ServicioController(ServicioService servicioService,
                              TipoServicioService tipoServicioService) {
        this.servicioService = servicioService;
        this.tipoServicioService = tipoServicioService;
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        model.addAttribute("listaServicios", servicioService.listarServicios());
        model.addAttribute("listaTipos", tipoServicioService.listarTipos());
        model.addAttribute("servicioNuevo", new Servicio());
        return "servicios/listado";
    }

    @PostMapping("/guardar")
    public String guardarServicio(@Valid @ModelAttribute("servicioNuevo") Servicio servicio,
                                  BindingResult resultado,
                                  RedirectAttributes redirectAttributes) {
        if (resultado.hasErrors()) {
            redirectAttributes.addFlashAttribute("mensajeError",
                    "Revisá los datos: " + resultado.getFieldErrors().get(0).getDefaultMessage());
            return "redirect:/servicios/listado";
        }
        boolean esNuevo = servicio.getId() == null;
        servicioService.guardarServicio(servicio);
        redirectAttributes.addFlashAttribute("mensajeExito",
                esNuevo ? "Servicio agregado correctamente."
                        : "Servicio modificado correctamente.");
        return "redirect:/servicios/listado";
    }

    @GetMapping("/modifica/{id}")
    public String mostrarEdicion(@PathVariable Integer id,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        return servicioService.buscarServicioPorId(id)
                .map(servicio -> {
                    model.addAttribute("servicioEdicion", servicio);
                    model.addAttribute("listaTipos", tipoServicioService.listarTipos());
                    return "servicios/modifica";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("mensajeError", "El servicio no existe.");
                    return "redirect:/servicios/listado";
                });
    }

    @PostMapping("/eliminar")
    public String eliminarServicio(@RequestParam Integer idServicio,
                                   RedirectAttributes redirectAttributes) {
        try {
            servicioService.eliminarServicio(idServicio);
            redirectAttributes.addFlashAttribute("mensajeExito", "Servicio eliminado correctamente.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            redirectAttributes.addFlashAttribute("mensajeError", e.getMessage());
        }
        return "redirect:/servicios/listado";
    } 
}
