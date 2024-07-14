package com.alura.literatura.literatura.controller;

import java.util.Scanner;

public class Funcionalidades {
    private String parametroBusqueda;

    public String getParametroBusqueda() {
        return parametroBusqueda;
    }

    public void setParametroBusqueda(String parametroBusqueda) {
        this.parametroBusqueda = parametroBusqueda;
    }

    public void menuOpciones(){
        System.out.println("\nBienvenido ingresa una opcion en la busqueda de tu libro".toUpperCase() +"\n\n" +
                "************************************************\n\n" +
                "(1)-->  Libro por titulo.\n"+
                "(2)-->  Libros registrados\n" +
                "(3)-->  Autores registrados\n" +
                "(4)-->  Autores vivos por año\n" +
                "(5)-->  Libros por idioma\n" +
                "(0)-->  Salir\n" +
                "************************************************\n\n");
    }


    public String url(int opcion, String urlBase) {
        Scanner teclado = new Scanner(System.in);
        String urlCompleta;
        if (opcion == 1 ) {
            System.out.println("Escribe el titulo del libro :");
            this.parametroBusqueda =  teclado.nextLine();
            urlCompleta = urlBase + "?search=" + parametroBusqueda.replace(" ", "%20");
            return urlCompleta;
        }
        return urlBase;

    }



}
