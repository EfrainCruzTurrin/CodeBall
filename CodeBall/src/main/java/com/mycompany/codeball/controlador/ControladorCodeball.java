/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codeball.controlador;

import com.mycompany.codeball.VistaTpi.Vista;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

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
        vista.mensaje("Ingrsese el nombre.");
        String nombre = vista.pedirString();
        vista.mensaje("Ingrsese el apellido.");
        String apellido = vista.pedirString();
        vista.mensaje("Ingrsese la fecha de nacimiento.");
        Date fecha = vista.pedirFecha();
        jugadores.add(new Jugador(dni, nombre, apellido, fecha));
    }

    public void registrarArbitro() {
//        private int dni;
//        private String nombre;
//        private String apellido;
//        private Date fechaNacimiento;
        vista.mensaje("Ingrsese el DNI o codigo de identificación similar.");
        int dni = vista.pedirInt();
        vista.mensaje("Ingrsese el nombre.");
        String nombre = vista.pedirString();
        vista.mensaje("Ingrsese el apellido.");
        String apellido = vista.pedirString();
        vista.mensaje("Ingrsese la fecha de nacimiento.");
        Date fecha = vista.pedirFecha();
        boolean existencia = false;
        for (Jugador j : jugadores) {
            if (j.getDni() == dni) {
                existencia = true;
            }
        }
        if(existencia){
            vista.mensaje("Ese jugador ya existe.");
        }else{
            arbitros.add(new Arbitro(dni, nombre, apellido, fecha));
        }
        
    }

    public void registrarEquipo() {
        
//        private String nombre;
//        private int cantidadJugadores;
        vista.mensaje("Ingrsese el nombre.");
        String nombre = vista.pedirString();
        boolean existencia = false;
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                existencia = true;
            }
        }
        if(existencia){
            vista.mensaje("Ese equipo ya existe.");
        }else{
            equipos.add(new Equipo(nombre, 0));
        }
        
    }
    
    
}
