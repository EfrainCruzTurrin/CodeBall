package com.mycompany.codeball.modelo;

import java.util.ArrayList;

public class Torneo {
    private String descripcion;
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private Fase fase;

    public Torneo(String descripcion, Equipo equipo, Fase fase) {
        this.descripcion = descripcion;
        this.fase = fase;
    }

    public Torneo() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Fase getFase() {
        return fase;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return "Torneo{" + "descripcion=" + descripcion + ", fase=" + fase + '}';
    }
    
    
}
