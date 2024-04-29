package ejercicio02;

public class Horchata extends Comida {  // clase Horchata  hereda/extiende de la clase abstracta Comida por lo tanto contiene todos los métodos y atributos que contenga Comida y Vendible.

    private double cantidad;
    private double porcentajeChufa;

    public Horchata(String nombre, double precio, double kcal, double cantidad, double porcentajeChufa) { // le entra como parámetros sus atributos + los de la clase Padre
        super(nombre, precio,"Horchata", kcal); // con el super llamamos al constructor de la Clase Padre que ya consta definidos.
        this.cantidad = cantidad;
        this.porcentajeChufa = porcentajeChufa;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPorcentajeChufa() {
        return this.porcentajeChufa;
    }

    public void setPorcentajeChufa(double porcentajeChufa) {
        this.porcentajeChufa = porcentajeChufa;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " | Tipo: " + tipo + " | Precio: " + this.precio + "euros | Cantidad: " + this.cantidad + " | % de Chufa: " + this.porcentajeChufa + "% | Kcal: " + this.kcal;
    }
}
