package Adapter;

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
import static com.example.parcial1.MainActivity.listOrden;
import Entidades.InfoOrden;

public class Adaptad extends BaseAdapter {

    private List<InfoOrden> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;

    public List<InfoOrden> GetData(){
        return this.datasource;
    }

    //El constructor original sin img solo lleva public AdaptadorComida(Context context, int IdPlantilla, List<InfoOrden> sources)
    public Adaptad(Context context, int IdPlantilla, List<InfoOrden> sources){
        //Inicializamos las variables
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
    }

    @Override
    public int getCount() {
        return this.datasource.size();
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
        if(convertView == null){
            //Creamos el Administrador de Layout
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);
            //Le damos vida al archivo xml ahora es un Layout
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            //Buscamos los controles de nuestra plantilla
            TextView lbledad = convertView.findViewById(R.id.txvEdad);
            TextView lblubicacion = convertView.findViewById(R.id.txvUbicacion);

            //Obtenemos el dato a mostrar
            lbledad.setText(this.datasource.get(position).getEdad());
            lblubicacion.setText(this.datasource.get(position).getUbicacion());

        }
        return convertView;
    }
}
