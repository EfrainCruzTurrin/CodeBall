package com.mycompany.codeball.modelo;

public class Equipo {

    // idEquipo no era necesario
    private String nombre;
    private int cantidadJugadores;

    public Equipo(int idEquipo, String nombre, int cantidadJugadores) {
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
    }

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" + " nombre=" + nombre + ", cantidadJugadores=" + cantidadJugadores + '}';
    }

}
