package com.symb.task.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Details extends AppCompatActivity {
TextView mDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        mDetails=findViewById(R.id.details);
        setSupportActionBar(toolbar);
        Intent i= getIntent();
        Long id = i.getLongExtra("ID",0);
//        Toast.makeText(this, "ID ->"+id,Toast.LENGTH_SHORT).show();
        TodoListDb db= new TodoListDb(this);
        Todo_task todo=db.getTodo(id);
        getSupportActionBar().setTitle("Todo Note");
        getSupportActionBar().setTitle(getTitleColor());
        mDetails.setText(todo.getContent());


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
