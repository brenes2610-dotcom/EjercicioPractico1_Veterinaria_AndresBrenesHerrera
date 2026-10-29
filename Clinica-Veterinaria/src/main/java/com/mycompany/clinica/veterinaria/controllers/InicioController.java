/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinica.veterinaria.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author brene
 */
@Controller
public class InicioController {
        @GetMapping("/")
    public String mostrarInicio(Model model) {
        return "inicio";
    }

    @PostMapping("/consultas/enviar")
    public String recibirConsulta(@RequestParam String nombreRemitente,
                                  @RequestParam String correoRemitente,
                                  @RequestParam String nombreMascota,
                                  @RequestParam String textoConsulta,
                                  RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensajeExito",
                "¡Gracias, " + nombreRemitente + "! Recibimos tu consulta sobre " + nombreMascota
                + " y te responderemos pronto.");
        return "redirect:/#consultas";
    }
}
