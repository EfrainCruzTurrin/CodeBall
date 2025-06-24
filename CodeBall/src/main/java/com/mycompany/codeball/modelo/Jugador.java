package com.mycompany.codeball.modelo;

import java.sql.Date;

public class Jugador {

    private int idJugador;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private int idPosicion;
    private int idEquipo;

    public Jugador(int idJugador, String nombre, String apellido, String dni, Date fechaNacimiento, int idPosicion, int idEquipo) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.idPosicion = idPosicion;
        this.idEquipo = idEquipo;
    }

    public Jugador() {
    }

    public int getIdJugador() {
        return idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getIdPosicion() {
        return idPosicion;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setIdPosicion(int idPosicion) {
        this.idPosicion = idPosicion;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }


    @Override
    public String toString() {
        return "Jugador{" + "idJugador=" + idJugador + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", idPosicion=" + idPosicion + ", idEquipo=" + idEquipo + '}';
    }

}
