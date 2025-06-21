package com.mycompany.codeball;

import com.mycompany.codeball.controlador.ControladorCodeball;
import java.sql.SQLException;

public class CodeBall {

    public static void main(String[] args) throws SQLException {
        ControladorCodeball controlador = new ControladorCodeball();
        controlador.conectar();
        controlador.cargarEquipos();
        controlador.listarEquipos();
    }
}
