package com.mycompany.codeball.modelo;

import java.util.HashMap;

public class EquipoTemporada {

    private String fechaCreacion;
    private Equipo equipo;
    private HashMap<Jugador, Posicion> jugadorPosicion = new HashMap<>();

    public EquipoTemporada(String fechaCreacion, Equipo equipo) {
        this.fechaCreacion = fechaCreacion;
        this.equipo = equipo;
    }

    public EquipoTemporada() {
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public HashMap<Jugador, Posicion> getJugadorPosicion() {
        return jugadorPosicion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setJugadorPosicion(HashMap<Jugador, Posicion> jugadorPosicion) {
        this.jugadorPosicion = jugadorPosicion;
    }

    @Override
    public String toString() {
        return "EquipoTemporada{" + "fechaCreacion=" + fechaCreacion + ", equipo=" + equipo + ", jugadorPosicion=" + jugadorPosicion + '}';
    }

}
