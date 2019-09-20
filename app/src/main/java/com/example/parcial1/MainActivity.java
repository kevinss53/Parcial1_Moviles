package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Entidades.InfoOrden;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button nuevo,lista,procesar;
    public static List<InfoOrden> listOrden;
    public static List<String> listComida = new ArrayList<String>();
    public static int contador1;
    public static int contador2;
    public static int contador3;
    public static int contador4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nuevo = findViewById(R.id.btnnuevo);
        lista = findViewById(R.id.btnlista);
        procesar = findViewById(R.id.btnprocesar);
        listOrden = new ArrayList<>();


    }

    @Override
    public void onClick(View view) {
switch (view.getId()) {
    case R.id.btnlista: {
            if(listOrden.size()==0 || listOrden==null)
            {
               Toast.makeText(getApplicationContext(),"No hay datos en la lista",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Intent al = new Intent(this,Todo.class);
                startActivity(al);
            }
        break;
    }
    case R.id.btnnuevo:
    {
        Intent nuevo = new Intent(this,InfoPersonal.class);
        startActivity(nuevo);

        break;
    }

    case R.id.btnprocesar:
    {
      if(listOrden.size() ==0|| listOrden==null)
      {

          Toast.makeText(this,"No hay datos en la lista",Toast.LENGTH_SHORT).show();
      }
      else
      {
          Intent proceso = new Intent(this,lstorden.class);
          proceso.putExtra("cont1",contador1);
          proceso.putExtra("cont2",contador2);
          proceso.putExtra("cont3",contador3);
          proceso.putExtra("cont4",contador4);
            startActivity(proceso);
      }
        break;
    }

}
    }
}
