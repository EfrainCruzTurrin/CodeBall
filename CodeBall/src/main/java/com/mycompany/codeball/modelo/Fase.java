package com.mycompany.codeball.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Fase {

    protected String tipo;
    protected ArrayList<Partido> partidos = new ArrayList<>();
    protected HashMap<Jugador, Penalizacion> jugadoresPenalizados = new HashMap<>();

    public Fase(String tipo, ArrayList<Partido> partidos, HashMap<Jugador, Penalizacion> jugadoresPenalizados) {
        this.tipo = tipo;
        this.partidos = partidos;
        this.jugadoresPenalizados = jugadoresPenalizados;
    }

    public Fase() {
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public HashMap<Jugador, Penalizacion> getJugadoresPenalizados() {
        return jugadoresPenalizados;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public void setJugadoresPenalizados(HashMap<Jugador, Penalizacion> jugadoresPenalizados) {
        this.jugadoresPenalizados = jugadoresPenalizados;
    }

    @Override
    public String toString() {
        return "Fase{" + "tipo=" + tipo + ", partidos=" + partidos + ", jugadoresPenalizados=" + jugadoresPenalizados + '}';
    }
    
}
