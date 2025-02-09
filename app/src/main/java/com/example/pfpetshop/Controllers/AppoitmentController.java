package com.example.pfpetshop.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pfpetshop.AppoitmentAdapter;
import com.example.pfpetshop.DataBaseHelper;
import com.example.pfpetshop.Models.Appoitment;
import com.example.pfpetshop.Models.User;

import java.util.ArrayList;
import java.util.Date;

public class AppoitmentController {
    DataBaseHelper dataBaseHelper;
    public AppoitmentController(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
    }
    public long InsertPet(Appoitment appoitment){
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idUser", appoitment.getIdUser());
        contentValues.put("namePet", appoitment.getNamePet());
        contentValues.put("typePet", appoitment.getTypePet());
        return sqLiteDatabase.insert(dataBaseHelper.getTABLE_APPOITMENT(), null, contentValues);
    }
    public ArrayList<Appoitment> loadMeetingLV(){
        Appoitment appoitment;
        User user;
        ArrayList<Appoitment> appoitmentsList = new ArrayList<Appoitment>();
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT A.namePet, A.date , U.name, U.ci FROM appoitment A JOIN users U ON A.idUser = U.idUser;",null);
        if (cursor.moveToFirst()){
            do{
                String nameString = cursor.getString(0);
                String dateString = cursor.getString(1);
                String nameuserString = cursor.getString(2);
                String userciString = cursor.getString(3);
                appoitment = new Appoitment(nameString,dateString,nameuserString,userciString);
                appoitmentsList.add(appoitment);
            }while (cursor.moveToNext());
        }
        return appoitmentsList;
    }
}
