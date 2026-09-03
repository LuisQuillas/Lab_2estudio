package com.example.plantilla.entity;

import jakarta.persistence.*;

// ============================================================
//  ENTIDAD (mapea una tabla de la base de datos)
//  CAMBIA "Entidad" por el nombre de tu clase (ej. Mascota)
//  CAMBIA "entidad" (en @Table) por el nombre de tu tabla
// ============================================================
@Entity
@Table(name = "entidad")   // <-- CAMBIA AQUI el nombre de la tabla
public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // ----- CAMPOS: agrega/cambia los que necesites -----
    // Regla: @Column(name="...") debe ser IGUAL al nombre de la columna en la BD.
    // Usa Integer/Double (no int/double) para evitar errores con NULL.

    @Column(name = "campo1")   // <-- CAMBIA AQUI el nombre de la columna
    private String campo1;

    @Column(name = "campo2")   // <-- CAMBIA AQUI el nombre de la columna
    private String campo2;

    // ============================================================
    //  GETTERS Y SETTERS (SIEMPRE genéralos: Alt+Insert)
    //  Sin getters, Thymeleaf falla con "EL1008E".
    //  Cuando cambies los campos, borra estos y regenera con Alt+Insert.
    // ============================================================
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCampo1() { return campo1; }
    public void setCampo1(String campo1) { this.campo1 = campo1; }

    public String getCampo2() { return campo2; }
    public void setCampo2(String campo2) { this.campo2 = campo2; }
}
