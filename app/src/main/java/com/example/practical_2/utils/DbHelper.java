package com.example.practical_2.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private String table_name = "students";
    private String roll_no = "roll_no";
    private String name = "name";
    private static final int database_version = 1;

    private Context context;
    public DbHelper(Context context){
        super(context, "studinfo", null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table if not exists " + table_name + " (" + roll_no + " integer primary key, " + name + " text not null);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + table_name);
        onCreate(sqLiteDatabase);
    }
    public boolean insertStudent(String id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("roll_no", id);
        values.put("name", name);
        return db.insert(table_name, null, values) != -1;
    }
    public boolean deleteStudent(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table_name, "roll_no = ?", new String[] {id}) != -1;
    }
    public boolean updateStudent(String id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("roll_no", id);
        values.put("name", name);
        return db.update(table_name, values, "roll_no = ?", new String[] {id}) != -1;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + table_name, null);
        return res;
    }
}
