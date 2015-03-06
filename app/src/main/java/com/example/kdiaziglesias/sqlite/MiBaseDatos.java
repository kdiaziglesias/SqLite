package com.example.kdiaziglesias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MiBaseDatos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;

    private  static final String NOMBRE_BASEDATOS="mibasedatos.db";

    private static final String TABLA_CONTACTOS = "CREATE TABLE contactos"+"(_id INT PRIMARY KEY,nombre TEXT,telefono INT,email TEXT)";


     public MiBaseDatos(Context context){

         super(context,NOMBRE_BASEDATOS,null,VERSION_BASEDATOS);
     }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CONTACTOS);
    }

    public void  onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

        db.execSQL("DROP TABLE IF EXISTS "+ TABLA_CONTACTOS);
        onCreate(db);

    }

    public void insertarCONTACTO(int id, String nom, int tlf, String email) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("_id", id);
            valores.put("nombre", nom);
            valores.put("telefono", tlf);
            valores.put("email", email);
            db.insert("contactos", null, valores);
            db.close();
        }
    }

    public void modificarCONTACTO(int id, String nom, int tlf, String email){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("_id", id);
        valores.put("nombre", nom);
        valores.put("telefono", tlf);
        valores.put("email", email);
        db.update("contactos", valores, "_id=" + id, null);
        db.close();
    }

    public void borrarCONTACTO(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("contactos", "_id="+id, null);
        db.close();
    }




}
