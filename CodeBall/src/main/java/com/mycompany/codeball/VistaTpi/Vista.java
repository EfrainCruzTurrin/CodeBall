
package com.mycompany.codeball.VistaTpi;

import java.util.Scanner;


public class Vista {
    private Scanner sc = new Scanner (System.in);  
    
    public int pedirInt(){
        return Integer.parseInt(sc.nextLine()); 
    }
    
    public String pedirString(){
        return (sc.nextLine()); 
    }
    
    public void mensaje (String mensaje){
        System.out.println(mensaje);
    }
    
    public void mostrarMenu(){
        System.out.println("Elija una opción: " +
                "\n1-Registrar nuevo Jugador: " +
                "\n2-Registrar nuevo Equipo: " +
                "\n3-Registrar Árbitro: " +
                "\n4-Registrar Torneo" +
                "\n4-Registrar Partido" +
                "\n4-Registrar Torneo" +
                "\n6-Seleccionar Torneo: " +
                "\n5-Lista de Jugadores: " +
                "\n6-Lista de Equipos: " +
                "\n -Lista de Equipos: " +
                "\n0-Salir");
    }
    
    public void mostrarMenuTorneo(){
        System.out.println("Elija una opción: " +
                "\n1-Mostrar Resultados: " +
                "\n2-Listar Equipos: " +
                "\n4-Listar Partidos" +
                "\n4-Resultado de Fase de Puntos" +
                "\n0-Salir");
    }

    public void mostrarMenuEquipo(){
        System.out.println("Elija una opción: " +
                "\n1-Mostrar Partidos: " +
                "\n2-Listar Equipos: " +
                "\n4-Listar Partidos" +
                "\n4-Resultado de Fase de Puntos" +
                "\n0-Salir");
    }
}   
