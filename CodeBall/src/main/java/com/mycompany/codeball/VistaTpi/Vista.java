
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
                "\n5-Lista de Jugadores: " +
                "\n6-Lista de Equipos: " +
                "\n0-Salir");
    }


    public int getOpcionMenu(){
        this.mostrarMenu();                    // Mostrar las opciones
        System.out.print("Ingrese la opción: ");
        return this.sc.nextInt();              // Leer y retornar número elegido
    }
}
