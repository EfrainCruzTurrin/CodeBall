package com.mycompany.codeball.modelo;

public class Equipo {
    private int idEquipo;
    private String nombre;
    private int cantidadJugadores;

    public Equipo(int idEquipo, String nombre, int cantidadJugadores) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.cantidadJugadores = cantidadJugadores;
    }

    public Equipo() {
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", nombre=" + nombre + ", cantidadJugadores=" + cantidadJugadores + '}';
    }
    
    
}
