package com.symb.task.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Details extends AppCompatActivity {
TextView mDetails;
TodoListDb db;
Todo_task todo;
Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        mDetails=findViewById(R.id.Details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i =getIntent();
        final long id =i.getLongExtra("ID",0);
        Toast.makeText(this,"ID->"+ id , Toast.LENGTH_SHORT).show();
         db = new TodoListDb(this);
        todo=db.getTodo(id);
        mDetails.setText(todo.getContent());


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           db.deleteTodo(todo.getId());
          Toast.makeText(getApplicationContext(), "Todo is deleted", Toast.LENGTH_SHORT).show();
           startActivity(new Intent(getApplicationContext(),TodoList.class));

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.edit_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.editTodo)
            Toast.makeText(this,"Edit Note",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
