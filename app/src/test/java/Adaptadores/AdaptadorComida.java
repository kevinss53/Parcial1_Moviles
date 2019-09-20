package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parcial1.R;

import java.util.List;

import Entidades.InfoOrden;

public class AdaptadorComida extends BaseAdapter {

    private List<InfoOrden> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;


    public List<InfoOrden> GetData(){
        return this.datasource;
    }

    //El constructor original sin img solo lleva public AdaptadorComida(Context context, int IdPlantilla, List<InfoOrden> sources)
    public AdaptadorComida(Context context, int IdPlantilla, List<InfoOrden> sources){
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
        // this.imagenes = imagenes;  //Es para img
    }


    @Override
    public int getCount() {
        return datasource.size();
    }

    @Override
    public Object getItem(int position) {
        return this.datasource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ImageView imageView;
        if(convertView == null){
            //Creamos el Administrador de Layout
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);

            //Le damos vida al archivo xml ahora es un Layout
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            //Buscamos los controles de nuestra plantilla
            imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView txvEdad = convertView.findViewById(R.id.txvEdad);
            TextView txvUbicacion = convertView.findViewById(R.id.txvUbicacion);

            //Obtenemos el dato a mostrar
            txvEdad.setText(this.datasource.get(position).getEdad());
            txvUbicacion.setText(this.datasource.get(position).getUbicacion());

        }
        return convertView;
    }
}
