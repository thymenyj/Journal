package com.example.thymen.journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.KeyStore;
import java.util.Map;

import static android.provider.Contacts.SettingsColumns.KEY;

public class EntryDatabase extends SQLiteOpenHelper {
    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static EntryDatabase instance;
    public static EntryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new EntryDatabase(context, "fucku", null, 1 );
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table entries (id INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT, content TEXT, mood TEXT, timestamp DATETIME )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "entries");
        onCreate(db);
    }

//    public void selectAll(){
//        getWritableDatabase();
//        rawQuery = ("SELECT * FROM entries WHERE title = ? AND content = ? AND mood = ? AND timestamp = ?", new String[] {"id", "1984", "Fiction","Sad", "1"} )
//
//    }

}
