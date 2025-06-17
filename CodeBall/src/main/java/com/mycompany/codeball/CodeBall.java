package com.mycompany.codeball;

import com.mycompany.codeball.conexion.ConectarBD;
import com.mycompany.codeball.controlador.ControladorCodeball;

public class CodeBall {

    public static void main(String[] args) {
        ControladorCodeball controlador = new ControladorCodeball();
        controlador.conectar();
    }
}
