package com.example.pfpetshop.Models;

public class Session {

    public static Integer idUser;
    private String Role;
    public static String Name;


    public Session(Integer idUser){
        this.idUser = idUser;
    }
    public Session(Integer idUser,String name){
        this.idUser = idUser;
        Name = name;

    }


}
