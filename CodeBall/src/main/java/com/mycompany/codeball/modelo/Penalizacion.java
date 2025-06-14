package com.mycompany.codeball.modelo;

public class Penalizacion {
    private String descripcion;

    public Penalizacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Penalizacion() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Penalizacion{" + "descripcion=" + descripcion + '}';
    }
    
    
}
