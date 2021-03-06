package com.symb.task.todo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoList extends AppCompatActivity {
RecyclerView notesList;
Adapter adapter;
List<Todo_task> todoList;
TodoListDb db;
Todo_task todo;

TodoListDb mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        mDatabaseHelper= new TodoListDb(this);
        TodoListDb db=new TodoListDb(this);
        todoList=db.getTodos();
        notesList=(RecyclerView) findViewById(R.id.notes_list);
        notesList.setLayoutManager(new GridLayoutManager(this,2));
        adapter=new Adapter(this,todoList);
        notesList.setAdapter(adapter);






    }
}
