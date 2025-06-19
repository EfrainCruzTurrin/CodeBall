package com.mycompany.codeball.modelo;

public class Equipo {

    // idEquipo no era necesario
    private String nombre;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "Equipo{" + " nombre=" + nombre + '}';
    }

}
