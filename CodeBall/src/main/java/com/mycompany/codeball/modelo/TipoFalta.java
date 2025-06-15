package com.mycompany.codeball.modelo;

public class TipoFalta {
    private String descripcion;
    private String penalizacion;

    public TipoFalta(String descripcion, String penalizacion) {
        this.descripcion = descripcion;
        this.penalizacion = penalizacion;
    }

    public TipoFalta() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPenalizacion() {
        return penalizacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPenalizacion(String penalizacion) {
        this.penalizacion = penalizacion;
    }

    @Override
    public String toString() {
        return "TipoFalta{" + "descripcion=" + descripcion + ", penalizacion=" + penalizacion + '}';
    }

}
