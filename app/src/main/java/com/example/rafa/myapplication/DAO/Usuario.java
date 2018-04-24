package com.example.rafa.myapplication.DAO;

/**
 * Created by Rafa on 24/04/2018.
 */

public class Usuario {
    private String name;
    private String lastname;
    private String dni;
    private String password;
    private String mobile;
    private int id;

    public Usuario(){
        name = "";
        lastname = "";
        dni = "";
        password = "";
        mobile = "";
        id = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
