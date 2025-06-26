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
                mensaje("Entrada inválida. Ingrese un número: ");
            }
        }
    }
    
    public String pedirString(){
        return (sc.nextLine()); 
    }
    
    public Date pedirFecha(){
        mensaje("Ingrese el año: ");
        String anio = pedirString();
        mensaje("Ingrese el mes: ");
        String mes = pedirString();
        mensaje("Ingrese el dia: ");
        String dia = pedirString();
        Date fecha = Date.valueOf(anio+"-"+mes+"-"+dia);        
        return fecha; 
    }
    
    public void mensaje (String mensaje){
        System.out.println(mensaje);
    }
    
     public boolean eleccionSiNo(){ 
        int dato = 0;
        while(dato != 1 || dato != 2){
            mensaje("1. Si");
            mensaje("2. No");
            dato = pedirInt();
            if(dato != 1 || dato != 2){
                mensaje("Dato no valido.");
            }
        }
        boolean datoBool;
        if (dato == 1){
            datoBool = true;
        }else{
            datoBool = false;
        } 
        return datoBool;
    }  
      
    public void mostrarMenu(){
        mensaje("Elija una opción: " +
                "\n1-Registrar nuevo Jugador: " +
                "\n2-Registrar nuevo Equipo: " +
                "\n3-Registrar Árbitro: " +
                "\n4-Registrar Partido" +
                "\n5-Registrar Torneo" +
                "\n6-Seleccionar Torneo: " +
                "\n7-Lista de Jugadores: " +
                "\n8-Lista de Equipos por tiempo: " +
                "\n0-Salir");
    }
    
    public void mostrarMenuTorneo(){
        mensaje("Elija una opción: " +
                "\n1-Mostrar Resultados: " +
                "\n2-Listar Partidos" +
                "\n3-Listar Equipos" +
                "\n0-Salir");
    }

   
}  
