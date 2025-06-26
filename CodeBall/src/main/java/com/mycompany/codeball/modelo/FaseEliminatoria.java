package com.mycompany.codeball.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class FaseEliminatoria extends Fase {
    private FasePuntos fasePuntos;
    private ArrayList<EquipoTemporada> equiposIniciales = new ArrayList<>();
    private HashMap<Partido, FaseDeEliminatoria> equiposEliminados = new HashMap<>();
    

    public FaseEliminatoria(FasePuntos fasePuntos,ArrayList<Partido> partidos, HashMap<Jugador, Penalizacion> jugadoresPenalizados, ArrayList<EquipoTemporada> equiposIniciales, HashMap<Partido, FaseDeEliminatoria> equiposEliminados) {
          
        super("Eliminatoria", partidos, jugadoresPenalizados);
        this.fasePuntos = fasePuntos;
        this.equiposIniciales = equiposIniciales;
        this.equiposEliminados = equiposEliminados;
    } 
     
    public FaseEliminatoria() {
    }

    public ArrayList<EquipoTemporada> getEquiposIniciales() {
        return equiposIniciales;
    }

    public HashMap<Partido, FaseDeEliminatoria> getEquiposEliminados() {
        return equiposEliminados;
    }

    public FasePuntos getFasePuntos() {
        return fasePuntos;
    }

    public void setEquiposIniciales(ArrayList<EquipoTemporada> equiposIniciales) {
        this.equiposIniciales = equiposIniciales;
    }

    public void setEquiposEliminados(HashMap<Partido, FaseDeEliminatoria> equiposEliminados) {
        this.equiposEliminados = equiposEliminados;
    }

    public void setFasePuntos(FasePuntos fasePuntos) {
        this.fasePuntos = fasePuntos;
    }
    

    @Override
    public String toString() {
        return "FaseEliminatoria{" + "equiposIniciales=" + equiposIniciales + ", equiposEliminados=" + equiposEliminados + '}';
    }

}
