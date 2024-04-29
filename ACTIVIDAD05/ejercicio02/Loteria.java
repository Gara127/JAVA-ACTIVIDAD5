package ejercicio02;

public class Loteria implements Vendible { // Clase lotería hereda/implementa la interfaz Vendible por lo tanto contiene todos los métodos que contenga Vendible.
    private double precio;
    private String numeroLoteria;

    public Loteria(double precio, String numeroLoteria) {
        this.precio = precio;
        this.numeroLoteria = numeroLoteria;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override  // sobreescribimos elmétodo toString para poder mostrar facilmente los atributos de la clase Loteria.
    public String toString() {
        return "Número de Loteria: " + this.numeroLoteria + " | Precio: " + this.precio + "euros";
    }
}
