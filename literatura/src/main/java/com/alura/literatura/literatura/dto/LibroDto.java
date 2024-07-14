package com.alura.literatura.literatura.dto;

public record LibroDto(
        Long Id,
        String titulo,
         String autor,
        String idioma,
        Double numeroDeDescargas )
{}
