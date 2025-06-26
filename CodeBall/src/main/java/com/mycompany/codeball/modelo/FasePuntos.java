package com.mycompany.codeball.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class FasePuntos extends Fase {

    private HashMap<EquipoTemporada, ArrayList<Integer>> puntosGanados = new HashMap<>();
    private HashMap<EquipoTemporada, Integer> puntosTotalesPorEquipo = new HashMap<>();
    private ArrayList<Grupo> grupos = new ArrayList<>();

    public FasePuntos(ArrayList<Partido> partidos, HashMap<Jugador, Penalizacion> jugadoresPenalizados, ArrayList<Grupo> grupos) {
        super("Puntos", partidos, jugadoresPenalizados);
        this.grupos = grupos;
        this.puntosGanados.putAll(obtenerPuntos(partidos)); 
        this.puntosTotalesPorEquipo.putAll(puntosPorEquipo(this.puntosGanados));
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

    public HashMap<EquipoTemporada, ArrayList<Integer>> obtenerPuntos(ArrayList<Partido> partidos){
        HashMap<EquipoTemporada, ArrayList<Integer>> puntos = new HashMap<>();
        ArrayList<Integer> numeroPuntos = new ArrayList<>();
        
        
        for(Partido p: partidos){
            for(int i = 0; i <= 1;i++){
                if(!(puntos.keySet().contains(p.getEquipos().get(i)))){
                    puntos.put(p.getEquipos().get(i), numeroPuntos);
                }
            }
        }
        
        for(EquipoTemporada e: puntos.keySet()){
            numeroPuntos.clear();
            for(Partido p: partidos){
                if(p.getGanador().equals(e)){
                    numeroPuntos.add(3);
                }
            }
            puntos.get(e).addAll(numeroPuntos);
        }
        
        return puntos;
    }
    
    public HashMap<EquipoTemporada, Integer> puntosPorEquipo(HashMap<EquipoTemporada, ArrayList<Integer>> puntosGanados){
        int suma;
        HashMap<EquipoTemporada, Integer> puntosPorEquipo = new HashMap<>();
        for(EquipoTemporada e: puntosGanados.keySet()){
            suma = 0;
            for(int n: puntosGanados.get(e)){
                suma = suma + n;
            }
            puntosPorEquipo.put(e,suma);
        }
        return puntosPorEquipo;
    }
    
    @Override
    public String toString() {
        return "FasePuntos{" + "puntosGanados=" + puntosGanados + ", puntosTotalesPorEquipo=" + puntosTotalesPorEquipo + ", grupos=" + grupos + '}';
    }

}
