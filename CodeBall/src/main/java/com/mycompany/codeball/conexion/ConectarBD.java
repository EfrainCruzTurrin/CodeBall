package com.mycompany.codeball.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarBD {

    static String url = "jdbc:mysql://localhost:3306/codeball";
    static String user = "root";
    static String pass = "basededatos";

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}