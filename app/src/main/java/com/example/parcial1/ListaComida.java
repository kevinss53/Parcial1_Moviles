package com.example.parcial1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import Entidades.InfoOrden;

import static  com.example.parcial1.MainActivity.listComida;
import static com.example.parcial1.MainActivity.listOrden;
import  static com.example.parcial1.MainActivity.contador1;
import  static com.example.parcial1.MainActivity.contador2;
import  static com.example.parcial1.MainActivity.contador3;
import  static com.example.parcial1.MainActivity.contador4;

public class ListaComida extends AppCompatActivity {

   private ListView lstvComida;
   String edad;
   String ubicacion;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comida);
        AddComidas();
        lstvComida = findViewById(R.id.listcomidass);
        lstvComida.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listComida));

        Bundle receptor = getIntent().getExtras();
        edad = receptor.getString("edad");
        ubicacion = receptor.getString("ubicacion");

        lstvComida.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                if(position >= 0 && position < listComida.size()){
                    new AlertDialog.Builder(ListaComida.this).setTitle("¡Aviso!").setMessage("¿Desea seleccionar el plato \"" + listComida.get(position ) + "\"?")
                            .setNegativeButton(android.R.string.cancel, null)
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {// Agregamos y cerramos
                                    AddItemListaOrden(listComida.get(position));
                                    finish();
                                }
                            }).show();
                }
            }
        });



    }

    private void AddComidas(){
        if(listComida.isEmpty()){
            listComida.add("Carne Asada");
            listComida.add("Pechuga a la plancha");
            listComida.add("Lasagna");
            listComida.add("Torta Mexicana");
        }




    }
    private void AddItemListaOrden(String c){
        InfoOrden io = new InfoOrden();
        Bundle b = getIntent().getExtras();

        String e = b.getString("edad");
        String u = b.getString("ubicacion");

        //condiciones
        if(c== "Carne Asada"){contador1++;}
        if(c== "Pechuga a la plancha"){contador2++;}
        if(c== "Lasagna"){contador3++;}
        if(c== "Torta Mexicana"){contador4++;}

        io.setEdad(e);
        io.setUbicacion(u);
        io.setComida(c);

        listOrden.add(io);
        Toast.makeText(this,"el contador de carne asada "+contador1,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"el contador de pechuga a la plancha "+contador2,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"el contador de lagsana "+contador3,Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"el contador de Torta Mexicana "+contador4,Toast.LENGTH_SHORT).show();
    }


}
