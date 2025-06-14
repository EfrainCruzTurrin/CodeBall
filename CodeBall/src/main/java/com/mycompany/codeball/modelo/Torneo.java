package com.mycompany.codeball.modelo;

public class Torneo {
    private String descripcion;
    private Equipo equipo;
    private Fase fase;

    public Torneo(String descripcion, Equipo equipo, Fase fase) {
        this.descripcion = descripcion;
        this.equipo = equipo;
        this.fase = fase;
    }

    public Torneo() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Fase getFase() {
        return fase;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return "Torneo{" + "descripcion=" + descripcion + ", equipo=" + equipo + ", fase=" + fase + '}';
    }
    
    
}
