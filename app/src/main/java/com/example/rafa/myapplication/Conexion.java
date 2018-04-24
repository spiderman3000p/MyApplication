package com.example.rafa.myapplication;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Rafa on 23/04/2018.
 */

public class Conexion {
    private static final String USER = "sql10234175";
    private static final String PASS = "GaYqBKVq21";
    private static final String DB_URL = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10234175";
    private static boolean success;
    public static Connection connection;
    public static Statement statement;

    public static void crearConexion() throws InstantiationError, IllegalAccessException, ClassNotFoundException{
        try{
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
            if(connection == null){
                success = false;
            }else{
                   success = true;
                   statement = connection.createStatement();
            }
        } catch (SQLException | java.lang.NullPointerException e) {
            Log.e("app","Excepcion al conectar. " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void cerrarConexion(){
        try{
            if(statement != null)
                statement.close();

            if(connection != null)
                connection.close();
        }catch(SQLException e){
            e.printStackTrace();
            Log.e("app","Excepcion al cerrar conexion. "+ e.getMessage());
        }
    }
}
