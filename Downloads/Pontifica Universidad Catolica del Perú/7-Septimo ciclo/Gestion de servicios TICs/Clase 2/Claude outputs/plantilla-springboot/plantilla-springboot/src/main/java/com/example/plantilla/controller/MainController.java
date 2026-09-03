package com.example.plantilla.controller;

import com.example.plantilla.entity.Entidad;
import com.example.plantilla.repository.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// ============================================================
//  CONTROLADOR PRINCIPAL
//  Aquí están: la página de inicio + el CRUD completo de plantilla.
//  Cambia SOLO lo marcado con  <-- CAMBIA AQUI
// ============================================================
@Controller
public class MainController {

    // CAMBIA AQUI: tu repositorio (debe existir la clase con ese nombre)
    @Autowired
    EntidadRepository entidadRepository;

    // ===================== PAGINA DE INICIO =====================
    // Al correr el proyecto y entrar a  http://localhost:8080/  carga index.html
    @GetMapping("/")
    public String home() {
        return "index";   // <-- carga templates/index.html (NO le pongas .html)
    }

    // ============================================================
    //   CRUD PLANTILLA
    //   La ruta base aquí es "/entidad". CAMBIA "entidad" por lo tuyo
    //   (ej. "mascota") en TODAS las rutas de abajo.
    // ============================================================

    // ---------- LISTAR (muestra todos en una tabla) ----------
    @GetMapping("/entidad/listar")                 // <-- CAMBIA "/entidad"
    public String listar(Model model) {
        List<Entidad> lista = entidadRepository.findAll();   // <-- CAMBIA "Entidad"
        model.addAttribute("lista", lista);        // <-- CAMBIA "lista" (nombre que usará la vista)
        return "entidad/lista";                    // <-- CAMBIA por tu vista: templates/entidad/lista.html
    }

    // ---------- MOSTRAR FORMULARIO NUEVO ----------
    @GetMapping("/entidad/nuevo")                  // <-- CAMBIA "/entidad"
    public String nuevo() {
        return "entidad/new";                      // <-- CAMBIA por tu vista de formulario
    }

    // ---------- GUARDAR (registra uno nuevo o actualiza si tiene id) ----------
    @PostMapping("/entidad/guardar")               // <-- CAMBIA "/entidad"
    public String guardar(Entidad entidad) {       // <-- CAMBIA "Entidad" (Spring hace el data binding)
        entidadRepository.save(entidad);
        return "redirect:/entidad/listar";         // <-- CAMBIA la ruta de redirección
    }

    // ---------- EDITAR (carga los datos actuales en el formulario) ----------
    @GetMapping("/entidad/editar")                 // <-- CAMBIA "/entidad"
    public String editar(@RequestParam("id") Integer id, Model model) {
        Optional<Entidad> opt = entidadRepository.findById(id);   // <-- CAMBIA "Entidad"
        if (opt.isPresent()) {
            model.addAttribute("entidad", opt.get());   // <-- CAMBIA "entidad" (nombre para la vista)
            return "entidad/edit";                        // <-- CAMBIA por tu vista de edición
        }
        return "redirect:/entidad/listar";
    }

    // ---------- BORRAR ----------
    @GetMapping("/entidad/borrar")                 // <-- CAMBIA "/entidad"
    public String borrar(@RequestParam("id") Integer id) {
        entidadRepository.deleteById(id);
        return "redirect:/entidad/listar";         // <-- CAMBIA la ruta de redirección
    }
}
