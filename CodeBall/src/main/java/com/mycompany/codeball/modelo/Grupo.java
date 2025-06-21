package com.mycompany.codeball.modelo;

public class Grupo {
    private int id;
    private Equipo equipo;

    public Grupo(int id, Equipo equipo) {
        this.id = id;
        this.equipo = equipo;
    }

    public int getId() {
        return id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", equipo=" + equipo + '}';
    }
    
    
    
    
}
