package juanantonio.redsocialjuan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Collection;
import java.util.Collections;

/**
 * Activity que muestra la lista de los amigos que posees segun la cuenta elegida
 * Autor Juan Antonio
 */
public class ListAmigos extends AppCompatActivity {

    private FloatingActionButton fab;
    private ListView listaAmis;
    private ListaAmigosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_amigos);
        listaAmis = (ListView) findViewById(R.id.listAmigos);
        listaAmis.setDividerHeight(10);
        adapter = new ListaAmigosAdapter(this);
        adapter.orderAsc();
        fab = (FloatingActionButton) findViewById(R.id.fabadd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListAmigos.this, AddAmigo.class));
            }
        });

        listaAmis.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int i, long l) {
                final AlertDialog dialog = new AlertDialog.Builder(ListAmigos.this)
                        .setTitle(R.string.orderchoise)
                        .setSingleChoiceItems(getResources().getStringArray(R.array.orden), 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                switch (i){
                                    case 0:
                                        adapter.orderAsc();
                                        break;
                                    case 1:
                                        adapter.orderDes();
                                        break;
                                }
                            }
                        })
                        .create();
                dialog.show();
                return true;
            }
        });


        listaAmis.setAdapter(adapter);
    }


    @Override
    protected void onResume() {
        super.onResume();
        adapter.restart();
        adapter.orderAsc();

    }
}
