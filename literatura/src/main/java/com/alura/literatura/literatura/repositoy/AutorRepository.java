package com.alura.literatura.literatura.repositoy;


import com.alura.literatura.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository  extends JpaRepository<Autor,Long> {
    Autor findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :año AND a.fechaDeceso >= :año")
    List<Autor> autoresVivosEnDeterminadoAño (int año);

}
