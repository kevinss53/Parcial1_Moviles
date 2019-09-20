package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import Adapter.Adaptad;
import static com.example.parcial1.MainActivity.listOrden;
import Entidades.InfoOrden;

public class Todo extends AppCompatActivity {

    ListView listax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        this.listax = findViewById(R.id.listtodo);

        this.listax.setAdapter(new Adaptad(this,R.layout.listaitems,listOrden));

    }
}
