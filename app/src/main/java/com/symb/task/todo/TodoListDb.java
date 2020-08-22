package com.symb.task.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class TodoListDb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME="TodoList_dbs";
    private static final String DATABASE_TABLE="TodolistTables";

    //columns name for database table
    public static final String KEY_ID="id";
    public static final String KEY_CONTENT="content";
    public static final String KEY_DATE="date";


    TodoListDb(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE nametable(id INT PRIMARY KEY, content TEXT, date TEXT, time TEXT);
        String query="CREATE TABLE " + DATABASE_TABLE + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_CONTENT + " TEXT, " +
                KEY_DATE + " TEXT " +
                ")";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);


    }

    public long AddTodo(Todo_task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(KEY_CONTENT, task.getContent());
        c.put(KEY_DATE, task.getDate());

        long ID = db.insert(DATABASE_TABLE, null, c);
        Log.d("inserted", "ID: " + ID);
        if (ID == -1) {
            return 0;
        } else {
            return ID;

        }
    }
    public Todo_task getTodo(long id){
        // select * from databaseTable where id =1
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur= db.query(DATABASE_TABLE, new String[]{KEY_DATE,KEY_CONTENT,KEY_DATE},KEY_ID +"=?",
                new String[]{String.valueOf(id)}, null, null, null);
        if(cur!=null)
            cur.moveToFirst();

        return new Todo_task(cur.getLong(0), cur.getString(1), cur.getString(2));
    }
    public List<Todo_task> getTodos(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Todo_task> alllist=new ArrayList<>();
        //Select * from databasename
        String query = "SELECT * FROM " + DATABASE_TABLE;
        Cursor cur = db.rawQuery(query, null);
        if(cur.moveToFirst()){
            do {
                Todo_task task =new Todo_task();
                task.setId(cur.getLong(0));
                task.setContent(cur.getString(1));
                task.setDate(cur.getString(2));

                alllist.add(task);

            }while (cur.moveToNext());
        }
        return alllist;
    }
   public void deleteTodo(long id){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="DELETE FROM "+ DATABASE_TABLE + " WHERE "+ KEY_ID + "=?";
       Log.d(TAG, "deleteTodo: query:"+ query);
       db.execSQL(query);
    }
}
