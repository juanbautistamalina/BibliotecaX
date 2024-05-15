package com.example.BibliotecaX.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.example.BibliotecaX.model.DatosGenerales;
import com.example.BibliotecaX.model.ListaDatos;
import com.example.BibliotecaX.service.ConsumoAPI;
import com.example.BibliotecaX.service.ConvierteDatos;

public class Principal {
    private Scanner entrada = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://www.googleapis.com/books/v1/volumes?q=";
    private ConvierteDatos conversor = new ConvierteDatos();

    private String titulo;
    private List<String> autor;
    private String año_publicacion;
    private String descripcion;
    private List<String> categoria;
    private String preview;



    public void mostrarMenu() {
        System.out.println("----------------------------------------------------");
        System.out.println("|                 Biblioteca X App                  |");
        System.out.println("----------------------------------------------------");
        System.out.println("|  Opciones:                                        |");
        System.out.println("|        1. Buscar libros por título                |");
        System.out.println("|        2. Salir                                   |");
        System.out.println("----------------------------------------------------");
    }

    public int solicitarOpcion() {
        System.out.print("Ingrese el número de opción deseado: ");
        return entrada.nextInt();
    }

    public void iniciar() {

        
        int opcion;

        do {
            mostrarMenu();
            opcion = solicitarOpcion();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    // Busqueda de libros por nombre
                    System.out.println("Ingresa el titulo del libro que deseas buscar: ");
                    String titulo_libro = entrada.nextLine();
                    var url = consumoAPI.obtenerDatos(URL_BASE + titulo_libro.replace(" ", "+"));

                    // Datos Generales -> Datos -> DatosLibro
                    var datos = conversor.obtenerDatos(url, DatosGenerales.class);

                    // Filtrando el primer resultado
                    Optional<ListaDatos> libroBuscado = datos.items().stream()
                            .findFirst();

                    if (libroBuscado.isPresent()) {

                        // Validando Título
                        if (libroBuscado.get().volumeInfo().title() != null) {
                            this.titulo = libroBuscado.get().volumeInfo().title();
                        } else {
                            this.titulo = "NO DISPONIBLE";
                        }

                        // Validando Autor
                        if (libroBuscado.get().volumeInfo().autor() != null) {
                            this.autor = libroBuscado.get().volumeInfo().autor();
                        } else {
                            this.autor = new ArrayList<>();
                            this.autor.add("NO DISPONIBLE");
                        }

                        // Validando Fecha de Publicación
                        if (libroBuscado.get().volumeInfo().año_publicacion() != null) {
                            this.año_publicacion = libroBuscado.get().volumeInfo().año_publicacion();
                        } else {
                            this.año_publicacion = "NO DISPONIBLE";
                        }

                        // Validando Descripción
                        if (libroBuscado.get().volumeInfo().descripcion() != null) {
                            this.descripcion = libroBuscado.get().volumeInfo().descripcion();
                        } else {
                            this.descripcion = "NO DISPONIBLE";
                        }

                        // Validando Categoría
                        if (libroBuscado.get().volumeInfo().categoria() != null) {
                            this.categoria = libroBuscado.get().volumeInfo().categoria();
                        } else {
                            this.categoria = new ArrayList<>();
                            this.categoria.add("NO DISPONIBLE");
                        }

                        // Validando Preview
                        if (libroBuscado.get().volumeInfo().preview() != null) {
                            this.preview = libroBuscado.get().volumeInfo().preview();
                        } else {
                            this.preview = "NO DISPONIBLE";
                        }
                        


                        // Mostrando datos por consola
                        System.out.println("\n" +
                                "- Titulo: " + this.titulo + "\n" +
                                "- Autor: " + this.autor + "\n" +
                                "- Fecha de Publicación: " + this.año_publicacion + "\n" +
                                "- Categoría: " + this.categoria + "\n" +
                                "- Descripción: " + this.descripcion + "\n" +
                                "- Preview: " + this.preview + "\n\n");

                    } else {
                        System.out.println("No se ha encontrado el libro especificado.");
                    }
                    break;

                case 2:
                    System.out.println("¡Gracias por usar la Biblioteca X App! Hasta luego.");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 2);
    }
}
