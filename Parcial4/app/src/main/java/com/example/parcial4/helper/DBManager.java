package com.example.parcial4.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private BaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new BaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String nombre, String apellido, String direccion, String ciudad) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(BaseHelper.NOMBRES, nombre);
        contentValue.put(BaseHelper.APELLIDOS, apellido);
        contentValue.put(BaseHelper.DIRECCION, direccion);
        contentValue.put(BaseHelper.CIUDAD, ciudad);
        database.insert(BaseHelper.TABLE_NAMEcl, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { BaseHelper._ID, BaseHelper.NOMBRES, BaseHelper.APELLIDOS, BaseHelper.DIRECCION, BaseHelper.CIUDAD };
        Cursor cursor = database.query(BaseHelper.TABLE_NAMEcl, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String nombre, String apellido, String direccion, String ciudad) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BaseHelper.NOMBRES, nombre);
        contentValues.put(BaseHelper.APELLIDOS, apellido);
        contentValues.put(BaseHelper.DIRECCION, direccion);
        contentValues.put(BaseHelper.CIUDAD, ciudad);
        int i = database.update(BaseHelper.TABLE_NAMEcl, contentValues, BaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(BaseHelper.TABLE_NAMEcl, BaseHelper._ID + "=" + _id, null);
    }
}
