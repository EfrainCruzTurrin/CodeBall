/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codeball.controlador;

import com.mycompany.codeball.modelo.Arbitro;
import com.mycompany.codeball.modelo.Equipo;
import com.mycompany.codeball.modelo.EquipoTemporada;
import com.mycompany.codeball.modelo.Fase;
import com.mycompany.codeball.modelo.FaseDeEliminatoria;
import com.mycompany.codeball.modelo.FaseEliminatoria;
import com.mycompany.codeball.modelo.FasePuntos;
import com.mycompany.codeball.modelo.Jugador;
import com.mycompany.codeball.modelo.Partido;
import com.mycompany.codeball.modelo.Penalizacion;
import com.mycompany.codeball.modelo.Posicion;
import com.mycompany.codeball.modelo.TipoFalta;
import com.mycompany.codeball.modelo.Torneo;
import com.mycompany.codeball.vista.Vista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;

/**
 *
 * @author EFRAIN
 */
public class ControladorCodeball {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Arbitro> arbitros = new ArrayList<>();
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<EquipoTemporada> equipostemporada = new ArrayList<>();
    private ArrayList<Fase> fases = new ArrayList<>();
    private ArrayList<FasePuntos> fasesPuntos = new ArrayList<>();
    private ArrayList<FaseEliminatoria> fasesEliminatoria = new ArrayList<>();
    private ArrayList<Partido> partidos = new ArrayList<>();
    private ArrayList<Penalizacion> penalizaciones = new ArrayList<>();
    private ArrayList<Posicion> posiciones = new ArrayList<>();
    private ArrayList<TipoFalta> tipoFaltas = new ArrayList<>();
    private ArrayList<Torneo> torneos = new ArrayList<>();
    private ArrayList<FaseDeEliminatoria> fasesDeEliminatoria = new ArrayList<>();
    private Vista vista = new Vista();

    static String url = "jdbc:mysql://localhost:3306/codeball";
    static String user = "root";
    static String pass = "basededatos";

    public static void conectar() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarJugador() {
//        private int dni;
//        private String nombre;
//        private String apellido;
//        private Date fechaNacimiento;
        vista.mensaje("Ingrsese el DNI o numero de identificación similar.");
        int dni = vista.pedirInt();
        vista.mensaje("Ingrese el nombre.");
        String nombre = vista.pedirString();
        vista.mensaje("Ingrese el apellido.");
        String apellido = vista.pedirString();
        vista.mensaje("Ingrese la fecha de nacimiento.");
        Date fecha = vista.pedirFecha();

        boolean existencia = false;
        for (Jugador j : jugadores) {
            if (j.getDni() == dni) {
                existencia = true;
            }
        }
        if (existencia) {
            vista.mensaje("Ese codigo de identificacion ya existe.");
        } else {
            jugadores.add(new Jugador(dni, nombre, apellido, fecha));
        }
    }

    public void registrarArbitro() {
//        private int dni;
//        private String nombre;
//        private String apellido;
//        private Date fechaNacimiento;
        vista.mensaje("Ingrese el DNI o codigo de identificación similar.");
        int dni = vista.pedirInt();
        vista.mensaje("Ingrese el nombre.");
        String nombre = vista.pedirString();
        vista.mensaje("Ingrese el apellido.");
        String apellido = vista.pedirString();
        vista.mensaje("Ingrese la fecha de nacimiento.");
        Date fecha = vista.pedirFecha();

        boolean existencia = false;
        for (Arbitro a : arbitros) {
            if (a.getDni() == dni) {
                existencia = true;
            }
        }
        if (existencia) {
            vista.mensaje("Ese codigo de identificacion ya existe.");
        } else {
            arbitros.add(new Arbitro(dni, nombre, apellido, fecha));
        }
    }

    public void registrarEquipo() {
//        private String nombre;
//        private int cantidadJugadores;
        vista.mensaje("Ingrese el nombre.");
        String nombre = vista.pedirString();

        boolean existencia = false;
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                existencia = true;
            }
        }
        if (existencia) {
            vista.mensaje("Ese equipo ya existe.");
        } else {
            equipos.add(new Equipo(nombre));
        }
    }

    public void registrarEquipoTemporada() {
//    private Date fechaCreacion;
//    private Equipo equipo;
//    private HashMap<Jugador, Posicion> jugadorPosicion = new HashMap<>();
        vista.mensaje("Inserte a fecha de su creacion.");
        Date fecha = vista.pedirFecha();
        vista.mensaje("Seleccione al equipo que representa.");
        int contador = 1;
        for (Equipo e : equipos) {
            vista.mensaje(contador + " | " + e.getNombre());
            contador++;
        }
        int numeroDeEquipo = vista.pedirInt() - 1;
        ArrayList<Integer> numerosDejugadores = new ArrayList<>();
        vista.mensaje("Seleccione sus jugadores. ");

        int numeroRegistro = 1;
        while (numeroRegistro != 0) {

            contador = 1;
            vista.mensaje("0. Salir");
            for (Jugador j : jugadores) {
                vista.mensaje(contador + " | " + j.getDni() + " | " + j.getNombre() + " " + j.getApellido());
            }
            numeroRegistro = vista.pedirInt();

            if (numeroRegistro != 0) {
                if (numerosDejugadores.contains(numeroRegistro)) {
                    vista.mensaje("Ese jugador ya esta en el equipo.");
                } else {
                    numerosDejugadores.add(numeroRegistro);
                    vista.mensaje("Tus jugadores hasta ahora.");
                    for(int n: numerosDejugadores){
                        vista.mensaje(n + " | " + jugadores.get(n-1).getNombre() + " " + jugadores.get(n-1).getApellido() );
                    }
                    
                }
            }
        }

    }

}
