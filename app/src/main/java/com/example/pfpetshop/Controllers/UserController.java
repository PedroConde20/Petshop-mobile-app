package com.example.pfpetshop.Controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.RelativeDateTimeFormatter;

import com.example.pfpetshop.DataBaseHelper;
import com.example.pfpetshop.Models.Appoitment;
import com.example.pfpetshop.Models.Session;
import com.example.pfpetshop.Models.User;

import java.util.ArrayList;

public class UserController {
    DataBaseHelper dataBaseHelper;

    public UserController(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
    }

    public long insertUser(User user){
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",user.getName());
        cv.put("lastname",user.getLastname());
        cv.put("username",user.getUsername());
        cv.put("ci",user.getCi());
        cv.put("email",user.getEmail());
        cv.put("password",user.getPassword());
        return db.insert(dataBaseHelper.getTABLE_USERS(),null,cv);
    }

    public boolean validateUser(String user, String password){
        boolean res = false;
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("Select username, password FROM users ;",null);
        if (cursor.moveToFirst()){
            do {
                String userCur = cursor.getString(0);
                String passCur = cursor.getString(1);
                if ((userCur.equals(user) )&&(passCur.equals(password))){
                    res = true;
                    break;
                }
            }while(cursor.moveToNext());
        }
        return res;
    }
    public ArrayList<User> loaduUser(){
        User user;
        ArrayList<User> userArrayList = new ArrayList<User>();
        SQLiteDatabase sqLiteDatabase = dataBaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT name, ci FROM users;",null);
        if (cursor.moveToFirst()){
            do{
                String nameString = cursor.getString(0);
                String ciString = cursor.getString(1);

                user = new User(nameString,ciString);
                userArrayList.add(user);
            }while (cursor.moveToNext());
        }
        return userArrayList;
    }

    public Session SelectUserID(){
        User user  = new User();
        Session session = null;
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT idUser,name FROM users",null);
        if (cursor.moveToFirst()){
            do {
                Integer idUser = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                session = new Session(idUser,name);
            }while (cursor.moveToNext());
        }
        return session;
    }
}
