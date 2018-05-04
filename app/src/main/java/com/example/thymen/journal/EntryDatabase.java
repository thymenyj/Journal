package com.example.thymen.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
            instance = new EntryDatabase(context, "hello", null, 1 );
        }
        return instance;
//        insert();
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

    public Cursor selectAll(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM entries WHERE title = ? AND content = ? AND mood = ? AND timestamp = ?", new String[] {null, null, null, null} );
        return cursor;
    }

    public void insert(JournalEntry journal) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", journal.getTitle());
        values.put("content", journal.getContent());
        values.put("mood", journal.getMood());
        values.put("timestamp", journal.getTimestamp());
        database.insert("entries", null, values);
        database.close();
    }

    public void delete(long id) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL("DELETE FROM entries WHERE id = id ");
    }

}
