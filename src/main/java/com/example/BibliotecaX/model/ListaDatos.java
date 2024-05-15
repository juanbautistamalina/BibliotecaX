package com.example.BibliotecaX.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListaDatos(@JsonAlias("volumeInfo") VolumeInfo volumeInfo) {
}
