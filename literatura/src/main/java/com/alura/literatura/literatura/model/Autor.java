package com.alura.literatura.literatura.model;

import jakarta.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaDeceso;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Libro> libros = new HashSet<>();

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = datosAutor.fechaNacimiento();
        this.fechaDeceso = datosAutor.fechaDeceso();
    }

    @Override
    public String toString() {
        return
                "AUTOR: " + nombre + '\n' +
                        "Fecha de Nacimiento: " + fechaNacimiento + '\n' +
                        "Fecha de Defuncion: " + fechaDeceso+ '\n' +
                        "Libros: " + (libros != null ?libros.stream()
                        .map(Libro::getTitulo)
                        .collect(Collectors.joining(", ")) : "N/A") +'\n' +
                        '\n';
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
        for (Libro libro : libros) {
            libro.setAutor(this);
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaDeceso() {
        return fechaDeceso;
    }

    public void setFechaDeceso(Integer fechaDeceso) {
        this.fechaDeceso = fechaDeceso;
    }
}
