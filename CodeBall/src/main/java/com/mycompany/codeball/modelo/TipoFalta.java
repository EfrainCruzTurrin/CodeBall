package com.mycompany.codeball.modelo;

public class TipoFalta {
    private int idFalta;
    private String descripcion;
    private String penalizacion;

    public TipoFalta(int idFalta, String descripcion, String penalizacion) {
        this.idFalta = idFalta;
        this.descripcion = descripcion;
        this.penalizacion = penalizacion;
    }

    public TipoFalta() {
    }

    public int getIdFalta() {
        return idFalta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPenalizacion() {
        return penalizacion;
    }

    public void setIdFalta(int idFalta) {
        this.idFalta = idFalta;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPenalizacion(String penalizacion) {
        this.penalizacion = penalizacion;
    }

    @Override
    public String toString() {
        return "TipoFalta{" + "idFalta=" + idFalta + ", descripcion=" + descripcion + ", penalizacion=" + penalizacion + '}';
    }
    
    
}
