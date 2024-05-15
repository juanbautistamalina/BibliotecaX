package com.example.BibliotecaX.model;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosGenerales(
    @JsonAlias("items") List<ListaDatos> items) {
}
