package com.example.plantilla.repository;

import com.example.plantilla.entity.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// ============================================================
//  REPOSITORIO (acceso a la base de datos, 1 sola línea)
//  CAMBIA "EntidadRepository" por el nombre que quieras (ej. MascotaRepository)
//  CAMBIA "Entidad" por tu entidad. El "Integer" es el tipo del @Id.
//  Con esto ya tienes GRATIS: findAll(), save(), findById(), deleteById(), count()...
// ============================================================
@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer> {

    // (Opcional) Aquí puedes agregar Query Methods, por ejemplo:
    // List<Entidad> findByCampo1ContainingIgnoreCase(String texto);
}
