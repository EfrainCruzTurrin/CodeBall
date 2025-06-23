package com.mycompany.codeball.modelo;

import java.util.ArrayList;

public class Grupo {
//    private int id;
    private ArrayList<EquipoTemporada> equipos = new ArrayList<>();

    public Grupo() {
    }

    
    public ArrayList<EquipoTemporada> getEquipos() {
        return equipos;
    }
    
    public void setEquipos(ArrayList<EquipoTemporada> equipos) {
        this.equipos = equipos;
    }
    
//    public Grupo(int id, Equipo equipo) {
//        this.id = id;
//        this.equipo = equipo;
//    }
    
//    public Grupo(Equipo equipo) {
//        this.equipo = equipo;
//    }

//    public int getId() {
//        return id;
//    }

//    public Equipo getEquipo() {
//        return equipo;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

//    public void setEquipo(Equipo equipo) {
//        this.equipo = equipo;
//    }

//    @Override
//    public String toString() {
//        return "Grupo{" + "id=" + id + ", equipo=" + equipo + '}';
//    }

    @Override
    public String toString() {
        return "Grupo{" + "equipos=" + equipos + '}';
    }
    
    
    
    
}
