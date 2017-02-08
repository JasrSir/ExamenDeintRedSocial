package juanantonio.redsocialjuan;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Estya clase representa el repositoriode toda la app, tanto de las cuentas creadas para las redes
 * así como las cuentas definidas para cada red social
 *Creado por Juan Antonio Suárez
 */

public class RepositorioSocial extends Application {

    private static RepositorioSocial mInstance;
    private static ArrayList<Amigos> mLista;
    private static ArrayList<Cuentas> mCuentas;
    private static int cuentaelegida = 0;
    public static final int FACEBOOK = 0;
    public static final int GMAIL = 1;
    public static final int TWITTER = 2;


    public RepositorioSocial() {
        if (mLista == null){
            mLista = new ArrayList<Amigos>();
            mLista.add(new Amigos("Juan","yo@facebook.com",FACEBOOK));
            mLista.add(new Amigos("Pepe","pepe@facebook.com",FACEBOOK));
            mLista.add(new Amigos("alfo","jaja@facebook.com",FACEBOOK));
            mLista.add(new Amigos("Juan","sdfsd@gmail.com",GMAIL));
            mLista.add(new Amigos("Pepe","vvcx@gmail.com",GMAIL));
            mLista.add(new Amigos("alfo","eewew@gmail.com",GMAIL));
            mLista.add(new Amigos("Juan","hola@twitter.com", TWITTER));
            mLista.add(new Amigos("Pepe","sfs@twitter.com",TWITTER));
            mLista.add(new Amigos("alfo","ueuej@twitter.com",TWITTER));
        }
        if (mCuentas == null){
            mCuentas = new ArrayList<>();
            mCuentas.add(new Cuentas("Lourdes", "facebook",FACEBOOK));
            mCuentas.add(new Cuentas("Eliseo", "gmail",GMAIL));
            mCuentas.add(new Cuentas("Sebas", "twitter",TWITTER));

        }

    }

    static RepositorioSocial getmInstance() {
        if (mInstance == null)
            mInstance = new RepositorioSocial();
        return mInstance;
    }


    public static ArrayList<Amigos> getmLista() {
        return mLista;
    }

    public static ArrayList<Cuentas> getmCuentas() {
        return mCuentas;
    }

    public static int getCuentaelegida() {
        return cuentaelegida;
    }

    public static void setCuentaelegida(int cuentaelegida) {
        RepositorioSocial.cuentaelegida = cuentaelegida;
    }
}
