package com.example.pfpetshop.Models;

import java.util.Date;

public class Appoitment extends User{
    private String namePet,typePet;
    private String date;
    private int idAppointment, idUser;

    public Appoitment(String namePet, String typePet, int idUser){
        this.namePet = namePet;
        this.typePet = typePet;
        this.idUser = idUser;
    }

    public Appoitment(String namePet) {
        this.namePet = namePet;
    }

    public Appoitment(String namePet, String date, String nameUser, String ciUser){
        super(nameUser,ciUser);
        this.namePet = namePet;
        this.date = date;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
