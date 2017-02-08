package juanantonio.redsocialjuan;

/**
 * clase modelo de las cuentas que hay en la app, así como su estructura
 * Creado por Juan Antonio Suárez
 */

final class Cuentas {
    private String nombre;
    private String pass;
    private int tipocuenta;

    public Cuentas(String nombre, String pass, int tipo) {
        this.nombre = nombre;
        this.pass = pass;
        this.tipocuenta = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(int tipocuenta) {
        this.tipocuenta = tipocuenta;
    }
}
