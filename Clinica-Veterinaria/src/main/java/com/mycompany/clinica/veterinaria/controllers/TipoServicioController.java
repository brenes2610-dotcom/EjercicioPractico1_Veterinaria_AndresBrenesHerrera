/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.veterinaria.controllers;
import com.mycompany.clinica.veterinaria.domain.TipoServicio;
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
@RequestMapping("/tipos")
public class TipoServicioController {
    
    private final TipoServicioService tipoServicioService;

    public TipoServicioController(TipoServicioService tipoServicioService) {
        this.tipoServicioService = tipoServicioService;
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        model.addAttribute("listaTipos", tipoServicioService.listarTipos());
        model.addAttribute("tipoNuevo", new TipoServicio());
        return "tipos/listado";
    }

    @PostMapping("/guardar")
    public String guardarTipo(@Valid @ModelAttribute("tipoNuevo") TipoServicio tipo,
                              BindingResult resultado,
                              RedirectAttributes redirectAttributes) {
        if (resultado.hasErrors()) {
            redirectAttributes.addFlashAttribute("mensajeError",
                    "Revisá los datos: " + resultado.getFieldErrors().get(0).getDefaultMessage());
            return "redirect:/tipos/listado";
        }
        boolean esNuevo = tipo.getId() == null;
        tipoServicioService.guardarTipo(tipo);
        redirectAttributes.addFlashAttribute("mensajeExito",
                esNuevo ? "Tipo de servicio agregado correctamente."
                        : "Tipo de servicio modificado correctamente.");
        return "redirect:/tipos/listado";
    }

    @GetMapping("/modifica/{id}")
    public String mostrarEdicion(@PathVariable Integer id,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        return tipoServicioService.buscarTipoPorId(id)
                .map(tipo -> {
                    model.addAttribute("tipoEdicion", tipo);
                    return "tipos/modifica";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("mensajeError", "El tipo de servicio no existe.");
                    return "redirect:/tipos/listado";
                });
    }

    @PostMapping("/eliminar")
    public String eliminarTipo(@RequestParam Integer idTipo,
                               RedirectAttributes redirectAttributes) {
        try {
            tipoServicioService.eliminarTipo(idTipo);
            redirectAttributes.addFlashAttribute("mensajeExito", "Tipo de servicio eliminado correctamente.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            redirectAttributes.addFlashAttribute("mensajeError", e.getMessage());
        }
        return "redirect:/tipos/listado";
    }
}
