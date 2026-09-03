package com.example.lab2.controller;

import com.example.lab2.entity.Mascota;
import com.example.lab2.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    MascotaRepository mascotaRepository;

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Mascota> listaMascotas = mascotaRepository.findAll();
        model.addAttribute("listaMascotas", listaMascotas);
        return "mascota/lista";
    }

    // Muestra el formulario de registro
    @GetMapping("/nuevo")
    public String nuevo() {
        return "mascota/new";
    }

    // Recibe el formulario y guarda
    @PostMapping("/guardar")
    public String guardar(Mascota mascota) {
        mascotaRepository.save(mascota);
        return "redirect:/mascota/listar";
    }
}