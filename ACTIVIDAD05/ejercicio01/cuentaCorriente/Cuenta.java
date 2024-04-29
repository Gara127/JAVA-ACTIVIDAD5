package ejercicio01.cuentaCorriente;

public class Cuenta {
    private String numCuenta; // al ser un atributo de clase private solo se puede acceder desde la clase Cuenta. Si quieres acceder desde fuera getters and setters.
    private double saldo;
    private String nombre;

    public Cuenta(String numCuenta, double saldo, String nombre) { // construcctores de la clase. Aquí se inicializa los atributos.
        this.numCuenta = numCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNumCuenta() {
        return this.numCuenta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void mostrarInfo(){
        System.out.println("Numero de cuenta: " + this.numCuenta);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Nombre del Titular: " + this.nombre);
        System.out.println();
    }
}

