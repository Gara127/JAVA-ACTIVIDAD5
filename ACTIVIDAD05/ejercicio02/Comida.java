package ejercicio02;
                                                // Clase abstracta de la que no se puede crear objetos sino heredarla desde clases hijas. 
abstract class Comida implements Vendible {  // clase Comida hereda/implementa la interfaz Vendible por lo tanto contiene todos los métodos que contenga Vendible.
    protected String nombre; // variable protegida para poder acceder a ellas solo desde otras clases hijas, sin recurrir a los getters y setters del private.
    protected double precio;
    protected static String tipo;
    protected double kcal;

    public Comida(String nombre, double precio, double kcal) { // Constructor por defecto, inicializa los atributos y para el "tipo" pone un valor por defecto "comida"
        tipo = "Comida";          // al ser de tipo estática no hace falta usar el this para acceder a ellas. Los atributos y métodos static se pueden acceder sin llamar al objeto.
        this.nombre = nombre;
        this.precio = precio;
        this.kcal = kcal;
    }

    public Comida(String nombre, double precio, String nuevoTipo, double kcal) {
        tipo = nuevoTipo;
        this.nombre = nombre;
        this.precio = precio;
        this.kcal = kcal;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {  // sobreescribimos elmétodo toString para poder mostrar facilmente los atributos de la clase Comida.
        return "Nombre: " + this.nombre + " | Tipo: " + tipo +  " | kcal: " + this.kcal + " | Precio: " + this.precio + "euros";
    }
}
