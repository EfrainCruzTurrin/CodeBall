package com.mycompany.codeball.modelo;

import java.sql.Date;
import java.util.ArrayList;

public class EquipoTemporada {


    private Equipo equipo;
    private ArrayList<Jugador> jugadores = new ArrayList<>();

    public EquipoTemporada(Equipo equipo) {

        this.equipo = equipo;
    }

    public EquipoTemporada() {
    }


    public Equipo getEquipo() {
        return equipo;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }



    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

       public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
       
    @Override
    public String toString() {
        return "EquipoTemporada{" +  ", equipo=" + equipo + ", jugadorPosicion=" + jugadores + '}';
    }

}
