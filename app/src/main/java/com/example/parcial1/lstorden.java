package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import  static com.example.parcial1.MainActivity.contador1;
import  static com.example.parcial1.MainActivity.contador2;
import  static com.example.parcial1.MainActivity.contador3;
import  static com.example.parcial1.MainActivity.contador4;
import static  com.example.parcial1.MainActivity.listComida;

public class lstorden extends AppCompatActivity {

    int n1,n2,n3,n4;
    List<String> lista = new ArrayList<>();

    ListView lissss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lstorden);
        lissss = findViewById(R.id.lstcontadores);

        Bundle receptor = getIntent().getExtras();
        n1 = receptor.getInt("cont1");
        n2 = receptor.getInt("cont2");
        n3 = receptor.getInt("cont3");
        n4 = receptor.getInt("cont4");

        int total = n1+n2+n3+n4;

        double por1 =(contador1*100)/total;
        double por2 =(contador2*100)/total;
        double por3 =(contador3*100)/total;
        double por4 =(contador4*100)/total;


if(n1 >0)
{
    if(n1>1)
    {
        lista.add("Carne asada seleccionada "+contador1+" veces ("+por1+"%)" );
    }
    else
    {
        lista.add("Carne asada seleccionada una ves ("+por1+"%)" );
    }

}
if(n2 >0)
{
    if(n2>1)
    {
        lista.add("Carne asada seleccionada "+contador2+" veces ("+por2+"%)" );
    }
    else
    {
        lista.add("Carne asada seleccionada una ves ("+por2+"%)" );
    }
}
if(n3 >0)
{
    if(n3>1)
    {
        lista.add("Carne asada seleccionada "+contador3+" veces ("+por3+"%)" );
    }
    else
    {
        lista.add("Carne asada seleccionada una ves ("+por3+"%)" );
    }
}
if(n4 >0)
{
    if(n4>1)
    {
        lista.add("Carne asada seleccionada "+contador4+" veces ("+por4+"%)" );
    }
    else
    {
        lista.add("Carne asada seleccionada una ves ("+por4+"%)" );
    }
}






        lissss.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lista));


    }
   private void agregardatos()
   {

   }

}
