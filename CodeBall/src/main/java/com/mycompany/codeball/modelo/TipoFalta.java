package com.mycompany.codeball.modelo;

public class TipoFalta {
    private String descripcion;
    private Penalizacion penalizacion;

    public TipoFalta(String descripcion, Penalizacion penalizacion) {
        this.descripcion = descripcion;
        this.penalizacion = penalizacion;
    }

    public TipoFalta() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Penalizacion getPenalizacion() {
        return penalizacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPenalizacion(Penalizacion penalizacion) {
        this.penalizacion = penalizacion;
    }

    @Override
    public String toString() {
        return "TipoFalta{" + "descripcion=" + descripcion + ", penalizacion=" + penalizacion + '}';
    }

}
