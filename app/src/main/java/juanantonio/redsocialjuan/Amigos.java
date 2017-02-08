package juanantonio.redsocialjuan;

/**
 * Clase que define y almacena los amigos de la red social
 * Implementa la interfaz comparable para la ordenación.
 * Creado por Juan Antonio Suárez
 */

public class Amigos implements Comparable {
    private String nombre;
    private String correo;
    private int tipocuenta;

    public Amigos(String nombre, String correo, int tipocuenta) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipocuenta = tipocuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(int tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    @Override
    public int compareTo(Object o) {
        return this.getNombre().compareToIgnoreCase(((Amigos)o).getNombre());
    }
}
