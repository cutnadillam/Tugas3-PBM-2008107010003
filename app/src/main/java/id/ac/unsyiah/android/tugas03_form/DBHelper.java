package id.ac.unsyiah.android.tugas03_form;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "form.db";

    public DBHelper(MainActivity context) {
        super(context, "form.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(name TEXT primary key, npm TEXT, jurusan Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String name, String npm, String jurusan){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("npm", npm);
        contentValues.put("jurusan", jurusan);
        long result = MyDB.insert("users", null, contentValues);
        return result != -1;
    }

    public boolean checkname(String name){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where name =?", new String[] {name});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
