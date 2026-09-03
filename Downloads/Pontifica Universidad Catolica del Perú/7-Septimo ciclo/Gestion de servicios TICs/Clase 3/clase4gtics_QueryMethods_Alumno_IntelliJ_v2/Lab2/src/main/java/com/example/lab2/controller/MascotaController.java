package com.example.lab2.controller;

import com.example.lab2.entity.Mascota;
import com.example.lab2.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
