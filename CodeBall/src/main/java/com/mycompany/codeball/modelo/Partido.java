package com.mycompany.codeball.modelo;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;

public class Partido {

    private Date fecha;
    private ArrayList<EquipoTemporada> equipos = new ArrayList<>();
    private HashMap<Jugador, ArrayList<TipoFalta>> faltas = new HashMap<>();
    private HashMap<EquipoTemporada, ArrayList<Jugador>> goles = new HashMap<>();
    private HashMap<EquipoTemporada, ArrayList<Jugador>> penalesDescisivos = new HashMap<>();
    private EquipoTemporada ganador;
    private EquipoTemporada perdedor;

    public Partido(Date fecha, ArrayList<EquipoTemporada> equipos, HashMap<Jugador, ArrayList<TipoFalta>> faltas, HashMap<EquipoTemporada, ArrayList<Jugador>> goles, HashMap<EquipoTemporada, ArrayList<Jugador>> penalesDescisivos) {
        this.fecha = fecha;
        this.equipos = equipos;
        this.faltas = faltas;
        this.goles = goles;
        this.penalesDescisivos = penalesDescisivos;
        this.ganador = determinarGanador();
        this.perdedor = determinarPerdedor();
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

    public EquipoTemporada determinarGanador() {
        int numeroGoles1 = 0;
        int numeroGoles2 = 0;
        EquipoTemporada equipo1 = equipos.get(0);
        EquipoTemporada equipo2 = equipos.get(0);
        int contador = 1;
        for (EquipoTemporada e : goles.keySet()) {
            if (contador == 1) {
                numeroGoles1 = goles.get(e).size();
                equipo1 = e;
                contador++;
            } else {
                numeroGoles2 = goles.get(e).size();
                equipo2 = e;
            }
        }
        if (numeroGoles1 == numeroGoles2) {
            contador = 1;
            for (EquipoTemporada e : penalesDescisivos.keySet()) {
                if (contador == 1) {
                    numeroGoles1 = penalesDescisivos.get(e).size();
                    equipo1 = e;
                    contador++;
                } else {
                    numeroGoles2 = penalesDescisivos.get(e).size();
                    equipo2 = e;
                }
            }

            if (numeroGoles1 > numeroGoles2) {
                return equipo1;
            } else {
                return equipo2;
            }

        } else if (numeroGoles1 > numeroGoles2) {
            return equipo1;
        } else {
            return equipo2;
        }

    }
    
    public EquipoTemporada determinarPerdedor(){
        EquipoTemporada perdedorUnico = equipos.get(0);
        for(EquipoTemporada e: equipos){
            if(ganador.equals(e)){
            }else{
                perdedorUnico = e;
            }
        }
        return perdedorUnico;
    }

    @Override
    public String toString() {
        return "Partido{" + "fecha=" + fecha + ", equipos=" + equipos + ", faltas=" + faltas + ", goles=" + goles + ", penalesDescisivos=" + penalesDescisivos + ", ganador=" + ganador + ", perdedor=" + perdedor + '}';
    }

}
