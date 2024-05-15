package com.example.BibliotecaX.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public record VolumeInfo(
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<String> autor,
    @JsonAlias("publishedDate") String año_publicacion,
    @JsonAlias("description") String descripcion,
    @JsonAlias("categories") List<String> categoria,
    @JsonAlias("previewLink") String preview
) {
    
}
