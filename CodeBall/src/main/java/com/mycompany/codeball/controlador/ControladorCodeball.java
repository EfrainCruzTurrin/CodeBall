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
import com.mycompany.codeball.modelo.Grupo;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author EFRAIN
 */
public class ControladorCodeball {

    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ArrayList<Arbitro> arbitros = new ArrayList<>();
    private ArrayList<Equipo> equipos = new ArrayList<>();
    private ArrayList<EquipoTemporada> equiposTemporada = new ArrayList<>();
    private ArrayList<Fase> fases = new ArrayList<>();
    private ArrayList<FasePuntos> fasesPuntos = new ArrayList<>();
    private ArrayList<FaseEliminatoria> fasesEliminatoria = new ArrayList<>();
    private ArrayList<Partido> partidos = new ArrayList<>();
    private ArrayList<Penalizacion> penalizaciones = new ArrayList<>();
    private ArrayList<Posicion> posiciones = new ArrayList<>();
    private ArrayList<TipoFalta> tipoFaltas = new ArrayList<>();
    private ArrayList<Torneo> torneos = new ArrayList<>();
    private ArrayList<FaseDeEliminatoria> fasesDeEliminatoria = new ArrayList<>();
    private ArrayList<Grupo> grupos = new ArrayList<>();
    private Vista vista = new Vista();

    private Connection con;
    static String url = "jdbc:mysql://localhost:3306/codeball";
    static String user = "root";
    static String pass = "basededatos";

    public void conectar() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void cargarEquipos() throws SQLException {
//        String sql = "SELECT id_equipo, nombre, pais, director_tecnico FROM equipo";
//        int puntos = 0;
//        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                Equipo e = new Equipo(
//                        rs.getInt("id_equipo"),
//                        rs.getString("nombre"),
//                        rs.getString("pais"),
//                        rs.getString("director_tecnico"),
//                        puntos
//                );
//                System.out.println("Cargando equipo: " + rs.getString("nombre"));
//                equipos.add(e);
//            }
//        }
//
//    }
    public void listarEquipos() {
        for (Equipo e : equipos) {
            System.out.println(e);
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

//METODO REGISTRAR EQUIPO COMENTADO
    public void registrarEquipo() {
        String nombre;

        vista.mensaje("Ingrese el nombre.");
        nombre = vista.pedirString();

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
//    private String fechaCreacion;
//    private Equipo equipo;
//    private ArrayList<Jugador> jugadores = new ArrayList<>();
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
                    for (int n : numerosDejugadores) {
                        vista.mensaje(n + " | " + jugadores.get(n - 1).getNombre() + " " + jugadores.get(n - 1).getApellido());
                    }

                    if (numerosDejugadores.size() > 11) {
                        vista.mensaje("Usted ya tiene 11 jugadores en su equipo ¿Desea seguir agregando más?");

                        if (vista.eleccionSiNo()) {
                        } else {
                            numeroRegistro = 0;
                            equiposTemporada.add(new EquipoTemporada(fecha, equipos.get(numeroDeEquipo)));
                            ArrayList<Jugador> jugadoresTemporalesMetodo = new ArrayList<>();
                            for (int n : numerosDejugadores) {
                                jugadoresTemporalesMetodo.add(jugadores.get(n - 1));
                            }
                            equiposTemporada.get(equiposTemporada.size() - 1).setJugadores(jugadoresTemporalesMetodo);
                        }
                    }
                }
            }
        }
    }

    public void registrarPartido() {
//      private Date fecha;
//      private ArrayList<EquipoTemporada> equipos = new ArrayList<>();
//      private HashMap<Jugador, ArrayList<TipoFalta>> faltas = new HashMap<>();
//      private HashMap<EquipoTemporada, ArrayList<Jugador>> goles = new HashMap<>();
//      private HashMap<EquipoTemporada, ArrayList<Jugador>> penalesDescisivos = new HashMap<>();
//      private EquipoTemporada ganador;
//      private EquipoTemporada perdedor;
//
//    public Partido(Date fecha, HashMap<Jugador, ArrayList<TipoFalta>> faltas, HashMap<EquipoTemporada, ArrayList<Jugador>> goles,HashMap<EquipoTemporada, ArrayList<Jugador>> penalesDescisivos) {
//        this.fecha = fecha;
//        this.faltas = faltas;
//        this.goles = goles;
//        this.penalesDescisivos = penalesDescisivos;
//    }

        vista.mensaje("Inserte la fecha del partido.");
        Date fecha = vista.pedirFecha();

        vista.mensaje("Seleccione a dos equipos.");
        int contador = 1;
        for (EquipoTemporada e : equiposTemporada) {
            vista.mensaje(contador + " | " + e.getFechaCreacion() + " | " + e.getEquipo().getNombre());
            contador++;
        }

        ArrayList<Integer> numeroEquipo = new ArrayList<>();
        while (numeroEquipo.size() < 2) {
            int numero = vista.pedirInt() - 1;

            if (numero < 0 || numero > equiposTemporada.size() || numeroEquipo.contains(numero)) {
                vista.mensaje("Numero invalido. Revise no ingresar el mismo equipo.");
            } else {
                numeroEquipo.add(numero);
            }
        }

        ArrayList<EquipoTemporada> equiposTemporales = new ArrayList<>();
        for (int n : numeroEquipo) {
            equiposTemporales.add(equiposTemporada.get(n));
        }

        vista.mensaje("Ocurrieron Faltas?");
        HashMap<Jugador, ArrayList<TipoFalta>> faltas = new HashMap<>();
        ArrayList<TipoFalta> faltasJugador = new ArrayList<>();
        ArrayList<Jugador> jugadoresTemporales = new ArrayList<>();
        int numero = 1;
        while (vista.eleccionSiNo()) {
            vista.mensaje("Que jugador la cometio?");
            contador = 1;

            for (EquipoTemporada e : equiposTemporales) {
                for (Jugador j : e.getJugadores()) {
                    vista.mensaje(contador + " | Equipo: " + e.getEquipo().getNombre() + " | " + j.getNombre() + " " + j.getApellido());
                    contador++;
                    jugadoresTemporales.add(j);
                }
            }

            do {
                numero = vista.pedirInt() - 1;
                if (numero < 0 || numero > jugadoresTemporales.size()) {
                    vista.mensaje("Dato fuera de rango.");
                }
            } while (numero < 0 || numero > jugadoresTemporales.size());

            faltas.put(jugadoresTemporales.get(numero), registrarFaltas());
            vista.mensaje("Se cometieron mas faltas?");
        }

        HashMap<EquipoTemporada, ArrayList<Jugador>> golesTemporales = new HashMap<>();
        ArrayList<Jugador> jugadoresConGol = new ArrayList<>();
        int numeroJugador;
        for (EquipoTemporada e : equiposTemporales) {
            vista.mensaje("Cuantos goles hizo " + e.getEquipo().getNombre() + " ( " + e.getFechaCreacion() + ") ?");
            numero = vista.pedirInt();
            vista.mensaje("Que jugador/es los hicieron? Añade un número a la vez.");
            contador = 1;
            for (Jugador j : e.getJugadores()) {
                vista.mensaje(contador + " | " + j.getNombre() + " " + j.getApellido());
            }

            while (jugadoresConGol.size() < numero) {
                numeroJugador = vista.pedirInt();
                if (numeroJugador < 0 || numeroJugador > (e.getJugadores().size() - 1)) {
                    vista.mensaje("Dato fuera de rango.");
                } else {
                    jugadoresConGol.add(e.getJugadores().get(numeroJugador));
                }
            }

            golesTemporales.put(e, jugadoresConGol);
        }
        HashMap<EquipoTemporada, ArrayList<Jugador>> penalesTemporales = new HashMap<>();
        vista.mensaje("Ubo penales descisivos?");
        if (vista.eleccionSiNo()) {

            ArrayList<Jugador> jugadoresConPenal = new ArrayList<>();

            for (EquipoTemporada e : equiposTemporales) {
                vista.mensaje("Cuantos penales metio " + e.getEquipo().getNombre() + " ( " + e.getFechaCreacion() + ") ?");
                numero = vista.pedirInt();
                vista.mensaje("Que jugador/es los hicieron? Añade un número a la vez.");
                contador = 1;
                for (Jugador j : e.getJugadores()) {
                    vista.mensaje(contador + " | " + j.getNombre() + " " + j.getApellido());
                }

                while (jugadoresConGol.size() < numero) {
                    numeroJugador = vista.pedirInt();
                    if (numeroJugador < 0 || numeroJugador > (e.getJugadores().size() - 1)) {
                        vista.mensaje("Dato fuera de rango.");
                    } else {
                        jugadoresConPenal.add(e.getJugadores().get(numeroJugador));
                    }
                }

                penalesTemporales.put(e, jugadoresConGol);
            }
        }

        partidos.add(new Partido(fecha, equiposTemporales, faltas, golesTemporales, penalesTemporales));
    }

    public ArrayList<TipoFalta> registrarFaltas() {
        vista.mensaje("Que faltas cometio?");
        int contador = 1;
        ArrayList<Integer> numerosFaltas = new ArrayList<>();
        for (TipoFalta f : tipoFaltas) {
            vista.mensaje(contador + " | " + f.getDescripcion());
        }
        do {
            int numero = vista.pedirInt() - 1;
            if (numero < 0 || numero > tipoFaltas.size()) {
                vista.mensaje("Dato fuera de rango.");
            } else {
                numerosFaltas.add(numero);
            }
            vista.mensaje("Cometio otra falta?");
        } while (vista.eleccionSiNo());

        ArrayList<TipoFalta> faltas = new ArrayList<>();

        for (int n : numerosFaltas) {
            faltas.add(tipoFaltas.get(n));
        }

        return faltas;
    }

    public void registrarGrupo() {
        vista.mensaje("Seleccione a 4 equipos.");
        int contador = 1;
        ArrayList<EquipoTemporada> equiposParaGrupo = new ArrayList<>();
        for (EquipoTemporada e : equiposTemporada) {
            vista.mensaje(contador + " | " + e.getEquipo().getNombre() + " ( " + e.getFechaCreacion() + " )");
            contador++;
        }
        int numero;
        while (equiposParaGrupo.size() < 4) {
            numero = vista.pedirInt() - 1;
            if (equiposParaGrupo.contains(numero) || numero < 0 || numero > (equiposTemporada.size() - 1)) {
                vista.mensaje("Dato fuera de rango.");
            } else {
                equiposParaGrupo.add(equiposTemporada.get(numero));
            }
        }
        grupos.add(new Grupo(equiposParaGrupo));
    }

    public void registrarFaseGrupo() {
////        public FasePuntos(ArrayList<Partido> partidos, 
////        HashMap<Jugador, Penalizacion> jugadoresPenalizados, 
////        HashMap<EquipoTemporada, ArrayList<Integer>> puntosGanados,
///         HashMap<EquipoTemporada, Integer> puntosTotalesPorEquipo,
///         ArrayList<Grupo> grupos) 
////        super("Puntos", partidos, jugadoresPenalizados);
////        this.puntosGanados = puntosGanados;
        vista.mensaje("Seleccione sus grupos.");
        ArrayList<Grupo> gruposTemporales = new ArrayList<>();
        int contador = 1;
        for (Grupo g : grupos) {
            vista.mensaje(contador + " | " + g.getEquipos().get(0).getEquipo().getNombre() + " | " + g.getEquipos().get(1).getEquipo().getNombre() + " | " + g.getEquipos().get(2).getEquipo().getNombre() + " | " + g.getEquipos().get(3).getEquipo().getNombre());
        }
        
        ArrayList<Integer> numerosDeGrupos = new ArrayList<>();
        int numero;
        while(numerosDeGrupos.size() < 8){
            numero = vista.pedirInt() - 1;
                
            if(numerosDeGrupos.contains(numero) || numero < 0 || numero > (equiposTemporada.size() - 1)){
                vista.mensaje("Dato fuera de rango o seleccion repetida.");
            }else{
                numerosDeGrupos.add(numero);
            }
        }
        
        for(int n: numerosDeGrupos){
            gruposTemporales.add(grupos.get(n));
        }
        
        fasesPuntos.add(new FasePuntos(filtrarPartidosPorGrupo(gruposTemporales,partidos), jugadoresPenalizados(filtrarPartidosPorGrupo(gruposTemporales,partidos)), gruposTemporales));
        
        
    }

    public ArrayList<Partido> filtrarPartidosPorGrupo(ArrayList<Grupo> gruposPara, ArrayList<Partido> partidosPara) {
        ArrayList<Partido> partidosTemporales = new ArrayList<>();
        for (Grupo g : gruposPara) {
            for (Partido p : partidosPara) {
                if (g.getEquipos().contains(p.getEquipos())) {
                    partidosTemporales.add(p);
                }
            }
        }
        return partidosTemporales;
    }

    public HashMap<Jugador, Penalizacion> jugadoresPenalizados(ArrayList<Partido> partidosTemporales) {
        HashMap<Jugador, Penalizacion> jugadoresPenalizados = new HashMap<>();
        for (Partido p : partidosTemporales) {
            for (Jugador j : p.getFaltas().keySet()) {
                for (TipoFalta t : p.getFaltas().get(j)) {
                    if (!(t.getPenalizacion().equals(null))) {
                        jugadoresPenalizados.put(j, t.getPenalizacion());
                    }
                }
            }
        }
        return jugadoresPenalizados;
    }

//Registrar:
//    Jugador           [x]
//    Arbitro           [x]
//    Equipo            [x]
//    EquipoTemporada   [x]
//    FaseEliminatoria  []
//    FasePuntos        [x]
//    Grupo             [x]
//    Partido           [x]
//    Torneo            []
//    Falta el interior dejugadores Penalizados()    
//Consultas:
//    mostrarMenuTorneo(){
//          "Elija una opción: " +          
//          1-Mostrar Resultados: " +       []
//          2-Listar Equipos: " +           []
//          4-Listar Partidos" +            []
//          5-Resultado de Fase de Puntos"  []
//          6-Resultado de Eliminatorias"   []
//    }
//
//    public void mostrarMenuEquipo(){
//        mensaje("Elija una opción: " +            
//                "\n1-Mostrar Partidos: " +        []
//                "\n2-Listar Equipos: " +          []
//                "\n4-Listar Partidos" +           []
//                "\n4-Resultado de Fase de Puntos" []
}
