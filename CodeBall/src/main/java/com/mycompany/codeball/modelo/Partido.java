package com.mycompany.codeball.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Partido {
    private Date fecha;
    private ArrayList<EquipoTemporada> equipos = new ArrayList<>();
    private HashMap<Jugador, ArrayList<TipoFalta>> faltas = new HashMap<>();
    private HashMap<EquipoTemporada, ArrayList<Jugador>> goles = new HashMap<>();
    private HashMap<EquipoTemporada, ArrayList<Jugador>> penalesDescisivos = new HashMap<>();
    private EquipoTemporada ganador;
    private EquipoTemporada perdedor;

    public Partido(Date fecha, EquipoTemporada ganador, EquipoTemporada perdedor) {
        this.fecha = fecha;
        this.ganador = ganador;
        this.perdedor = perdedor;
    }

    public Partido() {
    }

    public Date getFecha() {
        return fecha;
    }

    public ArrayList<EquipoTemporada> getEquipos() {
        return equipos;
    }

    public HashMap<Jugador, ArrayList<TipoFalta>> getFaltas() {
        return faltas;
    }

    public HashMap<EquipoTemporada, ArrayList<Jugador>> getGoles() {
        return goles;
    }

    public HashMap<EquipoTemporada, ArrayList<Jugador>> getPenalesDescisivos() {
        return penalesDescisivos;
    }

    public EquipoTemporada getGanador() {
        return ganador;
    }

    public EquipoTemporada getPerdedor() {
        return perdedor;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEquipos(ArrayList<EquipoTemporada> equipos) {
        this.equipos = equipos;
    }

    public void setFaltas(HashMap<Jugador, ArrayList<TipoFalta>> faltas) {
        this.faltas = faltas;
    }

    public void setGoles(HashMap<EquipoTemporada, ArrayList<Jugador>> goles) {
        this.goles = goles;
    }

    public void setPenalesDescisivos(HashMap<EquipoTemporada, ArrayList<Jugador>> penalesDescisivos) {
        this.penalesDescisivos = penalesDescisivos;
    }

    public void setGanador(EquipoTemporada ganador) {
        this.ganador = ganador;
    }

    public void setPerdedor(EquipoTemporada perdedor) {
        this.perdedor = perdedor;
    }

    @Override
    public String toString() {
        return "Partido{" + "fecha=" + fecha + ", equipos=" + equipos + ", faltas=" + faltas + ", goles=" + goles + ", penalesDescisivos=" + penalesDescisivos + ", ganador=" + ganador + ", perdedor=" + perdedor + '}';
    }
    
    
    
}
