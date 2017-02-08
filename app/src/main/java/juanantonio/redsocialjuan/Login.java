package juanantonio.redsocialjuan;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Creado por Juan Antonio Suárez
 * Esta clase Te logea y te comprueba los datos que has introducido, así como dejarte pasar o no a la app,
 * por defecto esta asignada la cuenta de facebook
 */
public class Login extends AppCompatActivity {

    private EditText mName;
    private EditText mPass;
    private Button mLogin;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mName = (EditText) findViewById(R.id.edtName);
        mPass = (EditText) findViewById(R.id.edtPass);
        mLogin = (Button) findViewById(R.id.btnLogin);
        title = (TextView) findViewById(R.id.titleSocial);
        Typeface font = Typeface.createFromAsset(getAssets(),"gloriahallelujah.ttf");
        title.setTypeface(font);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobar();
            }
        });
    }

    private void comprobar() {
        if (mName.getText().toString().isEmpty() ||mPass.getText().toString().isEmpty()){
            final AlertDialog dialog = new AlertDialog.Builder(Login.this)
                    .setTitle(R.string.titleChoise).setMessage(R.string.noCorrect)
                    .setPositiveButton(R.string.accep, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }).create();
            dialog.show();
        } else {
            ArrayList<Cuentas> cuentasComp = RepositorioSocial.getmCuentas();
            boolean verdad = false;

                    if (cuentasComp.get(RepositorioSocial.getCuentaelegida()).getNombre().equals(mName.getText().toString())
                            && cuentasComp.get(RepositorioSocial.getCuentaelegida()).getPass().equals(mPass.getText().toString()) ){
                        verdad = true;
                    } else{
                        final AlertDialog dialog = new AlertDialog.Builder(Login.this)
                                .setTitle(R.string.titleChoise).setMessage(R.string.incorrec)
                                .setPositiveButton(R.string.accep, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }).create();
                        dialog.show();
                    }

            if (verdad){
                startActivity(new Intent(Login.this, ListAmigos.class));
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.social, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final AlertDialog dialog = new AlertDialog.Builder(Login.this)
                .setSingleChoiceItems(getResources().getStringArray(R.array.sociales), 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        RepositorioSocial.setCuentaelegida(i);
                    }
                }).setTitle(R.string.titleChoise).create();
        dialog.show();

        return super.onOptionsItemSelected(item);
    }
}
