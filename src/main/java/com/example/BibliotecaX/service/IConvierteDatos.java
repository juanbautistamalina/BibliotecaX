package com.example.BibliotecaX.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);



}
