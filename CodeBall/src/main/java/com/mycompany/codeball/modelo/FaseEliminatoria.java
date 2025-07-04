package com.mycompany.codeball.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class FaseEliminatoria extends Fase {

    private ArrayList<EquipoTemporada> equiposIniciales = new ArrayList<>();
    private HashMap<EquipoTemporada, FaseDeEliminatoria> equiposEliminados = new HashMap<>();

    public FaseEliminatoria(ArrayList<Partido> partidos, HashMap<Jugador, Penalizacion> jugadoresPenalizados, ArrayList<EquipoTemporada> equiposIniciales, HashMap<EquipoTemporada, FaseDeEliminatoria> equiposEliminados) {
        super("Eliminatoria", partidos, jugadoresPenalizados);
        this.equiposIniciales = equiposIniciales;
        this.equiposEliminados = equiposEliminados;
    }

    public FaseEliminatoria() {
    }

    public ArrayList<EquipoTemporada> getEquiposIniciales() {
        return equiposIniciales;
    }

    public HashMap<EquipoTemporada, FaseDeEliminatoria> getEquiposEliminados() {
        return equiposEliminados;
    }

    public void setEquiposIniciales(ArrayList<EquipoTemporada> equiposIniciales) {
        this.equiposIniciales = equiposIniciales;
    }

    public void setEquiposEliminados(HashMap<EquipoTemporada, FaseDeEliminatoria> equiposEliminados) {
        this.equiposEliminados = equiposEliminados;
    }

    @Override
    public String toString() {
        return "FaseEliminatoria{" + "equiposIniciales=" + equiposIniciales + ", equiposEliminados=" + equiposEliminados + '}';
    }

}
