package com.mycompany.codeball.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class FasePuntos extends Fase {

    private HashMap<EquipoTemporada, ArrayList<Integer>> puntosGanados = new HashMap<>();
    private HashMap<EquipoTemporada, Integer> puntosTotalesPorEquipo = new HashMap<>();
    private ArrayList<Grupo> grupos = new ArrayList<>();

    public FasePuntos(ArrayList<Partido> partidos, HashMap<Jugador, Penalizacion> jugadoresPenalizados, HashMap<EquipoTemporada, ArrayList<Integer>> puntosGanados, HashMap<EquipoTemporada, Integer> puntosTotalesPorEquipo, ArrayList<Grupo> grupos) {
        super("Puntos", partidos, jugadoresPenalizados);
        this.grupos = grupos;
        this.puntosGanados = puntosGanados;
        this.puntosTotalesPorEquipo = puntosTotalesPorEquipo;
        
    }

    public FasePuntos() {
    }

    public HashMap<EquipoTemporada, ArrayList<Integer>> getPuntosGanados() {
        return puntosGanados;
    }

    public HashMap<EquipoTemporada, Integer> getPuntosTotalesPorEquipo() {
        return puntosTotalesPorEquipo;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void setPuntosGanados(HashMap<EquipoTemporada, ArrayList<Integer>> puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    public void setPuntosTotalesPorEquipo(HashMap<EquipoTemporada, Integer> puntosTotalesPorEquipo) {
        this.puntosTotalesPorEquipo = puntosTotalesPorEquipo;
    }

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    
    
    @Override
    public String toString() {
        return "FasePuntos{" + "puntosGanados=" + puntosGanados + ", puntosTotalesPorEquipo=" + puntosTotalesPorEquipo + ", grupos=" + grupos + '}';
    }

}
