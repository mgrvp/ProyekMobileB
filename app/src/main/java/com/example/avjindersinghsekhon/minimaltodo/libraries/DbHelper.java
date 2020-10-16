package com.example.avjindersinghsekhon.minimaltodo.libraries;

import android.app.Notification;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "kontak.db";
    private static final int DATABASE_VERSION = 5;
    private Context context;

    public DbHelper(Context context) {
        // Database yang akan dibuat bernama kontak.db dengan versi = 1
        // File tersebut berada di: /data/data/packagename/databases/
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE kontak(id integer PRIMARY KEY, nama VARCHAR, nomor VARCHAR, jenis VARCHAR, detail VARCHAR)";
        String sql2 = "CREATE TABLE stok(id integer PRIMARY KEY, nama VARCHAR, nomor VARCHAR)";

        db.execSQL(sql);
        db.execSQL(sql2); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS kontak";
        String sql2 = "DROP TABLE IF EXISTS stok";

        db.execSQL(sql);
        db.execSQL(sql2);

        this.onCreate(db);


    }
    public void executeWrite(String sql) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(sql);


    }




    public Cursor executeRead(String sql) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);
//        Cursor cursor2 = db.rawQuery(sql2, null);

        return cursor;
//        return cursor2;
    }


//    public void executeWrite(String sql2) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL(sql2);
//    }
}
