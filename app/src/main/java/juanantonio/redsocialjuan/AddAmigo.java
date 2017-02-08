package juanantonio.redsocialjuan;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Creado por Juan Antonio Suárez
 * Esta clase añade un nuevo amigo al repositorio y vuelve a la activity anterior donde se muestran los amigos
 * comprobando que exista un amigo con el coprreo proporcionado, controlando los cmapos vacíos y añadiendo el amigo
 * al repositorio si todoo ha ido bien
 */
public class AddAmigo extends AppCompatActivity {

    private EditText nombre;
    private EditText correo;
    private Button aniadir;
    private View vista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_amigo);
        nombre = (EditText) findViewById(R.id.edtAddamigoname);
        vista = findViewById(R.id.activity_add_amigo);
        correo = (EditText) findViewById(R.id.emailAddamigo);
        aniadir = (Button) findViewById(R.id.btnAddmas);
        aniadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (comprobarvacio()){
                    if (comprobarRepeticion()){
                        Amigos amigo = new Amigos(nombre.getText().toString(),correo.getText().toString(), RepositorioSocial.getCuentaelegida());
                        RepositorioSocial.getmLista().add(amigo);
                        finish();
                    }
                }
            }
        });
    }

    private boolean comprobarRepeticion() {
        for (Amigos amigo:RepositorioSocial.getmLista()) {
            if (amigo.getTipocuenta() == RepositorioSocial.getCuentaelegida()){
                if (amigo.getCorreo().equals(correo.getText().toString())){
                    final AlertDialog dialog = new AlertDialog.Builder(AddAmigo.this)
                            .setTitle(R.string.correo). setMessage(R.string.repe)
                            .setPositiveButton(R.string.vale, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })

                            .create();
                    dialog.show();
                    return false;
                }
            }
        }
        return true;
    }

    private boolean comprobarvacio() {
        if (nombre.getText().toString().isEmpty() || correo.getText().toString().isEmpty()){
            final AlertDialog dialog = new AlertDialog.Builder(AddAmigo.this)
                    .setTitle(R.string.error). setMessage(R.string.empty)
                    .setPositiveButton(R.string.vale, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })

                    .create();
            dialog.show();
            return false;
        } else
            return true;
    }
}
