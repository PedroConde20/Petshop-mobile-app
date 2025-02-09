package com.example.pfpetshop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static  final int DB_VERSION = 1;
    //private static  final int DB_VERSION2 = 2;
    private static final String DB_NAME = "PetShop.db";
    private String TABLE_USERS = "users";
    private String TABLE_APPOITMENT = "appoitment";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(" +
                "idUser INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL," +
                "lastname TEXT NOT NULL," +
                "username TEXT NOT NULL," +
                "ci TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "role TEXT NOT NULL DEFAULT 'user'," +
                "password TEXT NOT NULL); "
                , TABLE_USERS));
        sqLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(" +
                "idAppoitment INTEGER PRIMARY KEY AUTOINCREMENT," +
                "idUser INTEGER NOT NULL," +
                "namePet TEXT NOT NULL," +
                "typePet TEXT NOT NULL," +
                "date DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY(idUser) REFERENCES " +
                TABLE_USERS + "(idUser));",TABLE_APPOITMENT));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       /*if (i==1 && i1==2){
            sqLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(" +
                            "idUser INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name TEXT NOT NULL," +
                            "lastname TEXT NOT NULL," +
                            "username TEXT NOT NULL," +
                            "ci TEXT NOT NULL," +
                            "email TEXT NOT NULL," +
                            "role TEXT NOT NULL DEFAULT 'user'," +
                            "password TEXT NOT NULL); " +
                    "CREATE TABLE IF NOT EXISTS %s(" +
                            "idAppoitment INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "idUser INTEGER NOT NULL," +
                            "namePet TEXT NOT NULL," +
                            "typePet TEXT NOT NULL," +
                            "date DATETIME DEFAULT CURRENT_TIMESTAMP," +
                            "FOREIGN KEY(idUser) REFERENCES " +
                            TABLE_USERS + "(idUser));"
                    , TABLE_USERS,TABLE_APPOITMENT));

        }*/

    }

    public static int getDbVersion() {
        return DB_VERSION;
    }

    public static String getDbName() {
        return DB_NAME;
    }

    public String getTABLE_USERS() {
        return TABLE_USERS;
    }

    public String getTABLE_APPOITMENT() {
        return TABLE_APPOITMENT;
    }
}
