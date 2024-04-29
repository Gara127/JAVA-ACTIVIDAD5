package ejercicio02;

public class Cucurucho extends Comida {  // clase Cucurucho  hereda/extiende de la clase abstracta Comida por lo tanto contiene todos los métodos y atributos que contenga Comida y Vendible.

    private int numeroBolas;
    private Helado[] saborHelado; // creamos la clase Helado para poder mostrar + atributos de las bolas de helado (tipo edulcorante y %grasa)

    public Cucurucho(String nombre, double precio, double kcal, int numeroBolas) {
        super(nombre, precio,"Cucurucho", kcal);
        this.numeroBolas = numeroBolas;
        this.saborHelado = new Helado[numeroBolas];
    }

    public void addBolaHelado(String nombre, double precio, double kcal, String edulcorante, double porcentajeGrasa, int posicion) {
        if (posicion >= 0 && posicion < numeroBolas) {
            saborHelado[posicion] = new Helado(nombre, precio, kcal, edulcorante, porcentajeGrasa);
        } else {
            System.out.println("La posición introducida es incorrecta. Inserte una posición entre 0 y " + (numeroBolas-1));
        }
    }

    @Override //sobreescribimos el getPrecio de la Clase padre para que se calcule el precio del cucurucho con el precio de las bolas de helado.
    public double getPrecio() {
        double precioTotal = this.precio; // precio cucurucho
        for (int i=0; i<this.numeroBolas; i++) {
            precioTotal += this.saborHelado[i].precio; // + precio cada bola
        }

        return precioTotal;
    }

    @Override
    public String toString() {
        String info = "Nombre: " + this.nombre + " | Tipo: " + tipo + " | Precio: " + this.precio + "euros | Kcal: " + this.kcal + " | Número de Bolas: " + this.numeroBolas + " | ";
        for (int i=0; i<this.numeroBolas; i++) {
            info += "Bola " + i + ": " + this.saborHelado[i] + " | "; // el objeto de la Clase Helado llama a su método toString y muestra todos los atributos.
        }

        return info;
    }
}
