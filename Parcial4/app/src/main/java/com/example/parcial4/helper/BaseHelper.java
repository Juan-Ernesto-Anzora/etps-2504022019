package com.example.parcial4.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {

    // Database Information
    static final String DB_NAME = "BDRENTASAUTO.db";

    // database version
    static final int VERSION_BASEDATOS = 1;

    // Table Name
    public static final String TABLE_NAMEcl = "MD_Clientes";
    public static final String TABLE_NAMEclve = "MD_ClienteVehiculo";
    public static final String TABLE_NAMEve = "MD_Vehiculos";

    // Table columns Cliente
    public static final String _ID = "ID_Cliente";
    public static final String NOMBRES = "sNombreCliente";
    public static final String APELLIDOS = "sApellidosCliente";
    public static final String DIRECCION = "sDireccionCliente";
    public static final String CIUDAD = "sCiudadCliente";

    // Table columns Vehiculos
    public static final String _IDv = "ID_Vehiculo";
    public static final String MARCA = "sMarca";
    public static final String MODELO = "sModelo";

    // Table columns ClienteVehiculo
    public static final String MATRICULA = "sMatricula";
    public static final String KM = "sKilometros";

    // Creating table query
    private static final String CREATE_TABLEcl = "create table " + TABLE_NAMEcl + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOMBRES + " TEXT NOT NULL, "
            + APELLIDOS + " TEXT NOT NULL, "
            + DIRECCION + " TEXT NOT NULL, "
            + CIUDAD + " TEXT);";

    private static final String CREATE_TABLEve = "create table " + TABLE_NAMEve + "(" + _IDv
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MARCA + " TEXT NOT NULL, "
            + MODELO + " TEXT NOT NULL);";

    private static final String CREATE_TABLEclve = "create table " + TABLE_NAMEclve + "(" + _ID
            + _IDv
            + MATRICULA + " TEXT NOT NULL, "
            + KM + " TEXT NOT NULL);";

    public BaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLEcl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAMEcl);
        onCreate(db);
    }
}
