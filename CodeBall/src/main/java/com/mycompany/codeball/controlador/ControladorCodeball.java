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
import java.util.Collections;
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
        while (numerosDeGrupos.size() < 8) {
            numero = vista.pedirInt() - 1;

            if (numerosDeGrupos.contains(numero) || numero < 0 || numero > (equiposTemporada.size() - 1)) {
                vista.mensaje("Dato fuera de rango o seleccion repetida.");
            } else {
                numerosDeGrupos.add(numero);
            }
        }

        for (int n : numerosDeGrupos) {
            gruposTemporales.add(grupos.get(n));
        }

        fasesPuntos.add(new FasePuntos(filtrarPartidosPorGrupo(gruposTemporales, partidos), jugadoresPenalizados(filtrarPartidosPorGrupo(gruposTemporales, partidos)), gruposTemporales));

    }

    public ArrayList<Partido> filtrarPartidosPorGrupo(ArrayList<Grupo> gruposPara, ArrayList<Partido> partidosPara) {
        ArrayList<Partido> partidosTemporales = new ArrayList<>();
        vista.mensaje("Seleccione los partidos. Hasta que usted lo considere.");
        for (Grupo g : gruposPara) {
            for (Partido p : partidosPara) {
                if (g.getEquipos().contains(p.getEquipos().get(0)) && g.getEquipos().contains(p.getEquipos().get(1))) {

                    partidosTemporales.add(p);
                }
            }
        }
        ArrayList<Partido> partidosFinales = new ArrayList<>();
        int contador = 1;
        vista.mensaje("0 | Salir.");
        for (Partido p : partidosTemporales) {

            vista.mensaje(contador + " | " + p.getFecha() + " | " + p.getEquipos().get(0) + " vs. " + p.getEquipos().get(1));
        }
        int numero = 0;
        do {
            numero = vista.pedirInt();
            if ((numero < 1 || numero > partidosTemporales.size()) && numero != 0) {
                vista.mensaje("Dato fuera de rango.");
            } else if (numero == 0) {
            } else {
                partidosFinales.add(partidosTemporales.get(numero - 1));
            }
        } while (numero != 0);
        return partidosFinales;
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

    public void registrarFaseEliminatoria() {
//      
//      FasePuntos fasePuntos,
//      ArrayList<Partido> partidos, 
//      HashMap<Jugador, Penalizacion> jugadoresPenalizados, 
//      ArrayList<EquipoTemporada> equiposIniciales, 
//      HashMap<Partido, FaseDeEliminatoria> equiposEliminados
//        
//          super("Eliminatoria", partidos, jugadoresPenalizados);
//          this.fasePuntos = fasePuntos;
//          this.equiposIniciales = equiposIniciales;
//          this.equiposEliminados = equiposEliminados;
//    
        vista.mensaje("Seleccione a la fase de grupos de la que procede esta fase eliminatoria.");
        int contador = 1;
        int contador2 = 1;
        for (FasePuntos f : fasesPuntos) {
            vista.mensaje("Fase de grupos " + contador + ". ");
            contador++;
            contador2 = 1;
            for (Grupo g : f.getGrupos()) {
                vista.mensaje("Grupo " + contador2 + " | " + g.getEquipos().get(0).getEquipo().getNombre() + " | " + g.getEquipos().get(1).getEquipo().getNombre() + " | " + g.getEquipos().get(2).getEquipo().getNombre() + " | " + g.getEquipos().get(3).getEquipo().getNombre());
                contador2++;
            }
        }

        int numero;
        FasePuntos fase = fasesPuntos.get(0);
        do {
            numero = vista.pedirInt() - 1;
            if (numero < 0 || numero > (fasesPuntos.size() - 1)) {
                vista.mensaje("Dato fuera de rango.");
            } else {
                fase = fasesPuntos.get(numero);
            }

        } while (numero < 0 || numero > (fasesPuntos.size() - 1));

        ArrayList<EquipoTemporada> equiposDeInicio = new ArrayList<>();
        equiposDeInicio = conseguirEquiposIniciales(fase);

        HashMap<Jugador, Penalizacion> jugadoresPenalizados = new HashMap<>();
        jugadoresPenalizados.putAll(fase.getJugadoresPenalizados());

        vista.mensaje("Seleccione los partidos en orden.");
        ArrayList<Partido> octavos = new ArrayList<>();
        ArrayList<Partido> cuartos = new ArrayList<>();
        ArrayList<Partido> semi = new ArrayList<>();
        ArrayList<Partido> partidoFinal = new ArrayList<>();
        ArrayList<Partido> partidosTemporales = new ArrayList<>();
        for (Partido p : partidos) {
            if (equiposDeInicio.contains(p.getEquipos().get(0)) && equiposDeInicio.contains(p.getEquipos().get(1))) {
                partidosTemporales.add(p);
            }
        }

        ArrayList<Partido> partidosFinales = new ArrayList<>();
        contador = 1;
        for (Partido p : partidosTemporales) {
            vista.mensaje(contador + " | " + p.getFecha() + " | " + p.getEquipos().get(0) + " vs. " + p.getEquipos().get(1));
        }
        vista.mensaje("Elije los octavos");
        do {

            if (numero < 1 || numero > partidosTemporales.size()) {
                vista.mensaje("Dato fuera de rango.");
            } else {
                octavos.add(partidosTemporales.get(numero - 1));
            }

        } while (octavos.size() < 8);

        partidosFinales.addAll(octavos);

        vista.mensaje("Elije los cuartos");
        do {

            if (numero < 1 || numero > partidosTemporales.size()) {
                vista.mensaje("Dato fuera de rango.");
            } else {
                cuartos.add(partidosTemporales.get(numero - 1));
            }

        } while (cuartos.size() < 4);

        partidosFinales.addAll(cuartos);

        vista.mensaje("Elije las semi-finales");
        do {

            if (numero < 1 || numero > partidosTemporales.size()) {
                vista.mensaje("Dato fuera de rango.");
            } else {
                semi.add(partidosTemporales.get(numero - 1));
            }

        } while (semi.size() < 2);

        partidosFinales.addAll(semi);

        vista.mensaje("Elije la final");
        do {

            if (numero < 1 || numero > partidosTemporales.size()) {
                vista.mensaje("Dato fuera de rango.");
            } else {
                partidoFinal.add(partidosTemporales.get(numero - 1));
            }

        } while (partidoFinal.size() < 1);

        partidosFinales.addAll(partidoFinal);
        contador = 1;

        HashMap<Partido, FaseDeEliminatoria> equiposEliminados = new HashMap<>();

        for (Partido p : partidosFinales) {
            if (contador < 9) {
                equiposEliminados.put(p, fasesDeEliminatoria.get(0));
            } else if (contador < 13) {
                equiposEliminados.put(p, fasesDeEliminatoria.get(1));
            } else if (contador < 15) {
                equiposEliminados.put(p, fasesDeEliminatoria.get(2));
            } else {
                equiposEliminados.put(p, fasesDeEliminatoria.get(3));
            }
        }

        fasesEliminatoria.add(new FaseEliminatoria(fase, partidosFinales, jugadoresPenalizados, conseguirEquiposIniciales(fase), equiposEliminados));
    }

    public ArrayList<EquipoTemporada> conseguirEquiposIniciales(FasePuntos fase) {
        ArrayList<Grupo> gruposTemporales = new ArrayList<>();
        gruposTemporales.addAll(fase.getGrupos());
        ArrayList<EquipoTemporada> equiposTemporales = new ArrayList<>();
        ArrayList<EquipoTemporada> equiposFinales = new ArrayList<>();
        ArrayList<Integer> valores = new ArrayList<>();
        int i;
        for (Grupo g : gruposTemporales) {
            equiposTemporales.clear();
            valores.clear();
            equiposTemporales.addAll(g.getEquipos());
            for (EquipoTemporada e : equiposTemporales) {
                if (g.getEquipos().contains(e)) {
                    valores.add(fase.getPuntosTotalesPorEquipo().get(e));
                }

            }
            for (i = 1; i < 3; i++) {
                for (EquipoTemporada e : equiposTemporales) {

                    valores.addAll(fase.getPuntosTotalesPorEquipo().values());
                    if (fase.getPuntosTotalesPorEquipo().get(e).equals(Collections.max(valores))) {
                        equiposFinales.add(e);
                    }
                }
                valores.remove(Collections.max(valores));
            }
        }
        return equiposFinales;

    }

    public void registrarTorneo() {
//          public Torneo(String descripcion, 
//          FasePuntos fasePuntos, 
//          FaseEliminatoria faseEliminatoria)
        vista.mensaje("Elija una descrpcion para el torneo. Puede ser un nombre o su forma de identificarlo.");
        String descripcion = vista.pedirString();
        vista.mensaje("Elija su Fase eliminatoria.");

    }

    public void ejecutarMenuPrincipal() {
        vista.mostrarMenu();
        int opcion = 0;
        do {
            opcion = vista.pedirInt();
            switch (opcion) {
                case 1 -> {
                    registrarJugador();
                    break;
                }
                case 2 -> {
                    registrarEquipo();
                    break;
                }
                case 3 -> {
                    registrarArbitro();
                    break;
                }
                case 4 -> {
                    registrarPartido();
                    break;
                }
                case 5 -> {
                    registrarTorneo();
                    break;
                }
                case 6 -> {
                    ejecutarMenuTorneo();
                    break;
                }
                case 7 -> {
                    listarJugadores();
                    break;
                }
                case 8 -> {
                    listarEquiposPorTemporada();
                    break;
                }

            }
        } while (opcion != 0);
    }

    public void listarJugadores() {
        int contador = 1;
        vista.mensaje("N° | Nombre Completo | Fecha de nacimiento");
        for (Jugador j : jugadores) {

            vista.mensaje(contador + " | " + j.getNombre() + " " + j.getApellido() + " | " + j.getFechaNacimiento());
            contador++;
        }

    }

    public void listarEquiposPorTemporada() {
        int contador = 1;
        vista.mensaje("N° | Fecha de creacion | Nombre de equipo | Jugadores");
        for (EquipoTemporada e : equiposTemporada) {
            vista.mensaje(contador + " | " + e.getFechaCreacion() + " | " + e.getEquipo().getNombre() + " | ");
            for (Jugador j : e.getJugadores()) {
                System.out.print(j.getNombre() + " " + j.getApellido() + ", ");
            }
            contador++;
        }

    }

    public void ejecutarMenuTorneo() {
        vista.mostrarMenuTorneo();
        int opcion = 0;
        do {
            opcion = vista.pedirInt();
            switch (opcion) {
                case 1 -> {
                    mostrarResultados();
                    break;
                }
                case 2 -> {
                    listarPartidosTorneo();
                    break;
                }
                case 3 -> {
                    listarEquipoTorneo();
                    break;
                }
            }
        } while (opcion != 0);

    }

    public void mostrarResultados() {
        vista.mensaje("Seleccione un torneo.");
        int contador = 1;

        for (Torneo t : torneos) {
            vista.mensaje(contador + " | " + t.getDescripcion());
        }

        int numero = vista.pedirInt();
        vista.mensaje("Fase de grupos:");
        for (contador = 1; contador < 9; contador++) {

            vista.mensaje("Grupo" + contador + ": ");

            for (int contador2 = 0; contador2 > 3; contador2++) {
                vista.mensaje("Equipo " + (contador2 + 1) + torneos.get(numero).getFasePuntos().getGrupos().get(contador - 1).getEquipos().get(contador2).getEquipo().getNombre());
            }
        }

        vista.mensaje("Fase de Eliminatoria: ");
        contador = 1;
        for(Partido p:torneos.get(numero).getFaseEliminatoria().getEquiposEliminados().keySet()){
            if(contador < 9){
                if(contador == 1){
                    vista.mensaje("Octavos: ");
                }
                for(int i = 0;i<2;i++){
                    System.out.print(p.getEquipos().get(i));
                    if(i == 0){
                        System.out.print(" vs. ");
                    }
                }
                
            }
            if(contador < 13){
                if(contador == 9){
                    vista.mensaje("Cuartos: ");
                }
                for(int i = 0;i<2;i++){
                    System.out.print(p.getEquipos().get(i));
                    if(i == 0){
                        System.out.print(" vs. ");
                    }
                }
                
            }
            if(contador < 15){
                if(contador == 13){
                    vista.mensaje("Semi-finales: ");
                }
                for(int i = 0;i<2;i++){
                    System.out.print(p.getEquipos().get(i));
                    if(i == 0){
                        System.out.print(" vs. ");
                    }
                }
                
            }else{
                vista.mensaje("Final: ");
                for(int i = 0;i<2;i++){
                    System.out.print(p.getEquipos().get(i));
                    if(i == 0){
                        System.out.print(" vs. ");
                    }
                }
            }
            
            contador++;
        }
        
    }
    
    public void listarPartidosTorneo(){
        vista.mensaje("Seleccione un torneo.");
        int contador = 1;

        for (Torneo t : torneos) {
            vista.mensaje(contador + " | " + t.getDescripcion());
        }

        int numero = vista.pedirInt();
        vista.mensaje("Fase de grupos:");
        
        
    }
    
    public void listarEquipoTorneo() {
        vista.mensaje("Seleccione un torneo.");
        int contador = 1;

        for (Torneo t : torneos) {
            vista.mensaje(contador + " | " + t.getDescripcion());
        }

        int numero = vista.pedirInt();
        contador = 1;
        for(EquipoTemporada e: torneos.get(numero).getEquipos()){
            vista.mensaje(contador + " | " + e.getEquipo().getNombre() );
        }
    }

//    public void mostrarMenu(){
    //        mensaje("Elija una opción: " +
    //                "\n1-Registrar nuevo Jugador: " +
    //                "\n2-Registrar nuevo Equipo: " +
    //                "\n3-Registrar Árbitro: " +
    //                "\n4-Registrar Torneo" +
    //                "\n5-Registrar Partido" +
    //                "\n6-Registrar Torneo" +
    //                "\n7-Seleccionar Torneo: " +
    //                "\n8-Lista de Jugadores: " +
    //                "\n9-Lista de Equipos: " +
    //                "\n10-Lista de Equipos por tiempo: " +
    //                "\n0-Salir");
    //Registrar:
    //    Jugador           [x]
    //    Arbitro           [x]
    //    Equipo            [x]
    //    EquipoTemporada   [x]
    //    FaseEliminatoria  [x]
    //    FasePuntos        [x]
    //    Grupo             [x]
    //    Partido           [x]
    //    Torneo            [x] 
    //Consultas:
    //    mostrarMenuTorneo(){                  []
    //          "Elija una opción: " +          
    //          1-Mostrar Resultados: " +       []
    //          2-Listar Equipos: " +           []
    //          3-Listar Partidos" +            []
    //    }
    //
    //    public void mostrarMenuEquipo(){              []
    //        mensaje("Elija una opción: " +            
    //                "\n1-Mostrar Partidos: " +        []
    //                "\n2-Listar Equipos: " +          []
    //                "\n4-Listar Partidos" +           []
}
