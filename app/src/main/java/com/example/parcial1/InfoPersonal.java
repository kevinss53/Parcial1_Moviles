package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InfoPersonal extends AppCompatActivity implements View.OnClickListener {

    EditText txtedad, txtubicacion;
    Button btnlistaAlimentos;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_personal);
        txtedad = findViewById(R.id.edtEdad);
        txtubicacion = findViewById(R.id.edtUbicacion);
        btnlistaAlimentos = findViewById(R.id.btnlistar);

    }

    @Override
    public void onClick(View view) {

        String edad = txtedad.getText().toString();
        String ubicacion = txtubicacion.getText().toString();

        switch (view.getId())
        {
            case R.id.btnlistar:
            {
                if(edad.isEmpty())
                {
                    Toast.makeText(this,"ingrese edad",Toast.LENGTH_SHORT).show();
                }

               else if(ubicacion.isEmpty())
                {
                    Toast.makeText(this,"ingrese ubicacion",Toast.LENGTH_SHORT).show();
                }
               else
                {
                    Intent lis = new Intent(this,ListaComida.class);
                    lis.putExtra("ubicacion",ubicacion);
                    lis.putExtra("edad",edad);
                    startActivity(lis);
                    finish();
                }
            }
                break;
        }
    }
}
