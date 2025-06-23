package com.mycompany.codeball.modelo;

import java.sql.Date;
import java.util.ArrayList;

public class EquipoTemporada {

    private Date fechaCreacion;
    private Equipo equipo;
    private ArrayList<Jugador> jugadores = new ArrayList<>();

    public EquipoTemporada(Date fechaCreacion, Equipo equipo) {
        this.fechaCreacion = fechaCreacion;
        this.equipo = equipo;
    }

    public EquipoTemporada() {
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "EquipoTemporada{" + "fechaCreacion=" + fechaCreacion + ", equipo=" + equipo + ", jugadorPosicion=" + jugadores + '}';
    }

}
