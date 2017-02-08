package juanantonio.redsocialjuan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase adapter para el list view que incorpora el patron Holderview,
 * asi como metodos para laq ordenación y reseteo tras un cambio de configuracion
 * Creado por Juan Antonio Suárez
 */

public class ListaAmigosAdapter extends ArrayAdapter {

    private ArrayList<Amigos> amigos;

    class HolderView{
        TextView nombre;
        TextView correo;
    }

    public ListaAmigosAdapter(Context context) {
        super(context, R.layout.cardamigos);
        filtrar();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = convertView;
        HolderView holder;

        if (rootView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rootView = inflater.inflate(R.layout.cardamigos,null);
            holder = new HolderView();

            holder.nombre = (TextView) rootView.findViewById(R.id.txvNombre);
            holder.correo = (TextView) rootView.findViewById(R.id.txvcorreo);

            rootView.setTag(holder);
        } else{
            holder = (HolderView) rootView.getTag();
        }
            holder.nombre.setText(((Amigos)getItem(position)).getNombre());
            holder.correo.setText(((Amigos)getItem(position)).getCorreo());


        switch (RepositorioSocial.getCuentaelegida()){
            case RepositorioSocial.FACEBOOK:
                rootView.setBackgroundColor(getContext().getResources().getColor(R.color.facebook));
                break;
            case RepositorioSocial.GMAIL:
                rootView.setBackgroundColor(getContext().getResources().getColor(R.color.google));
                break;
            case RepositorioSocial.TWITTER:
                rootView.setBackgroundColor(getContext().getResources().getColor(R.color.twitter));
                break;
        }

        return rootView;
    }



    public void orderAsc() {
        clear();
        Collections.sort(amigos);
        addAll(amigos);
    }
    public void orderDes() {
        clear();
        Collections.reverse(amigos);
        addAll(amigos);
    }

    public void restart() {
        if (amigos != null){
            amigos = null;
            filtrar();
        }
    }

    private void filtrar(){
        clear();
        amigos = new ArrayList<>();
        for (Amigos amigo:RepositorioSocial.getmLista()) {
            if (RepositorioSocial.getCuentaelegida() == amigo.getTipocuenta()){
                add(amigo);
                amigos.add(amigo);
            }
        }
        notifyDataSetChanged();
    }

}
