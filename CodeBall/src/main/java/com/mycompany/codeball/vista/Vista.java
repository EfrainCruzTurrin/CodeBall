
package com.mycompany.codeball.vista;

import java.util.Scanner;
import java.sql.Date;


public class Vista {
    private Scanner sc = new Scanner (System.in);  
    
    public int pedirInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Ingrese un número: ");
            }
        }
    }
    
    public String pedirString(){
        return (sc.nextLine()); 
    }
    
    public Date pedirFecha(){
        System.out.print("Ingrese el año: ");
        String anio = pedirString();
        System.out.print("Ingrese el mes: ");
        String mes = pedirString();
        System.out.print("Ingrese el dia: ");
        String dia = pedirString();
        Date fecha = Date.valueOf(anio+"-"+mes+"-"+dia);        
        return fecha; 
    }
    
    public void mensaje (String mensaje){
        System.out.println(mensaje);
    }
    
     public int eleccionSiNo(){ 
        int dato = 0;
        while(dato != 1 || dato != 2){
            mensaje("1. Si");
            mensaje("2. No");
            dato = pedirInt();
            if(dato != 1 || dato != 2){
                mensaje("Dato no valido.");
            }
        }
        return dato;
    }
     
    public void mostrarMenu(){
        System.out.println("Elija una opción: " +
                "\n1-Registrar nuevo Jugador: " +
                "\n2-Registrar nuevo Equipo: " +
                "\n3-Registrar Árbitro: " +
                "\n4-Registrar Torneo" +
                "\n5-Registrar Partido" +
                "\n6-Registrar Torneo" +
                "\n7-Seleccionar Torneo: " +
                "\n8-Lista de Jugadores: " +
                "\n9-Lista de Equipos: " +
                "\n10-Lista de Equipos: " +
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
