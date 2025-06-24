package com.mycompany.codeball.modelo;

public class Equipo {

    // idEquipo no era necesario
  private int idEquipo;
    private String nombre;
//    private String pais;
//    private String entrenador;
//    private int puntos;

//    public Equipo(int id, String nombre, String pais, String entrenador, int puntos) {
////        this.id = id;
//        this.nombre = nombre;
////        this.pais = pais;
////        this.entrenador = entrenador;
////        this.puntos = puntos;
//    }

    public Equipo(int id,String nombre) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
    }

    public Equipo() {
    }
       
//    public int getId() {
//        return id;
//    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdEquipo(int idEquipo) {  
        this.idEquipo = idEquipo;
    }

//
//    public String getPais() {
//        return pais;
//    }
//
//    public String getEntrenador() {
//        return entrenador;
//    }
//
//    public int getPuntos() {
//        return puntos;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public void setPais(String pais) {
//        this.pais = pais;
//    }
//
//    public void setEntrenador(String entrenador) {
//        this.entrenador = entrenador;
//    }
//
//    public void setPuntos(int puntos) {
//        this.puntos = puntos;
//    }
//    @Override
//    public String toString() {
//        return "Equipo{" + "id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", entrenador=" + entrenador + ", puntos=" + puntos + '}';
//    }
    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + '}';
    }

    
}
