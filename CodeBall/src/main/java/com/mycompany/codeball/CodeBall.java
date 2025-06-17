package com.mycompany.codeball;

import com.mycompany.codeball.conexion.ConectarBD;

public class CodeBall {

    public static void main(String[] args) {
        ConectarBD bd = new ConectarBD();
        bd.conectar();
    }
}
