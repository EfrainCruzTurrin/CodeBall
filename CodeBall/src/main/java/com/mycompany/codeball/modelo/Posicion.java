package com.mycompany.codeball.modelo;

public class Posicion {
    private String descripcion;

    public Posicion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Posicion() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Posicion{" + "descripcion=" + descripcion + '}';
    }
    
    
}
