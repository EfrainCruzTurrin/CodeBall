package com.mycompany.codeball.modelo;

public class EquipoTemporada extends Equipo {
    private int idEquipoTemporada;
    private String fechaCreacion;
    private Equipo equipo;
    private Jugador jugador;

    public EquipoTemporada(int idEquipoTemporada, String fechaCreacion, Equipo equipo, Jugador jugador, int idEquipo, String nombre, int cantidadJugadores) {
        super(idEquipo, nombre, cantidadJugadores);
        this.idEquipoTemporada = idEquipoTemporada;
        this.fechaCreacion = fechaCreacion;
        this.equipo = equipo;
        this.jugador = jugador;
    }

    public EquipoTemporada(int idEquipoTemporada, String fechaCreacion, Equipo equipo, Jugador jugador) {
        this.idEquipoTemporada = idEquipoTemporada;
        this.fechaCreacion = fechaCreacion;
        this.equipo = equipo;
        this.jugador = jugador;
    }

    public EquipoTemporada() {
    }

    public int getIdEquipoTemporada() {
        return idEquipoTemporada;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setIdEquipoTemporada(int idEquipoTemporada) {
        this.idEquipoTemporada = idEquipoTemporada;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "EquipoTemporada{" + "idEquipoTemporada=" + idEquipoTemporada + ", fechaCreacion=" + fechaCreacion + ", equipo=" + equipo + ", jugador=" + jugador + '}';
    }
    
    
    
}
