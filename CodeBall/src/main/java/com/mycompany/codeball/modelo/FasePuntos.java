
package com.mycompany.codeball.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class FasePuntos extends Fase{
    private HashMap<EquipoTemporada, ArrayList<Integer>> puntosGanados = new HashMap<>();
    private HashMap<EquipoTemporada, Integer> puntosTotalesPorEquipo = new HashMap<>();

    public FasePuntos() {
        super("Puntos");
    }

    public HashMap<EquipoTemporada, ArrayList<Integer>> getPuntosGanados() {
        return puntosGanados;
    }

    public HashMap<EquipoTemporada, Integer> getPuntosTotalesPorEquipo() {
        return puntosTotalesPorEquipo;
    }

    public void setPuntosGanados(HashMap<EquipoTemporada, ArrayList<Integer>> puntosGanados) {
        this.puntosGanados = puntosGanados;
    }

    public void setPuntosTotalesPorEquipo(HashMap<EquipoTemporada, Integer> puntosTotalesPorEquipo) {
        this.puntosTotalesPorEquipo = puntosTotalesPorEquipo;
    }

    @Override
    public String toString() {
        return "FasePuntos{" + "puntosGanados=" + puntosGanados + ", puntosTotalesPorEquipo=" + puntosTotalesPorEquipo + '}';
    }
    
    
}
