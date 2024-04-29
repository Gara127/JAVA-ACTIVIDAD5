package ejercicio02;

public class Helado extends Comida { // creamos la clase Helado para poder mostrar + atributos de las bolas de helado (tipo edulcorante y %grasa)

    private String edulcorante;
    private double porcentajeGrasa;

    public Helado(String nombre, double precio, double kcal, String edulcorante, double porcentajeGrasa) {
        super(nombre, precio, "Bola de Helado", kcal);
        this.edulcorante = edulcorante;
        this.porcentajeGrasa = porcentajeGrasa;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " | Tipo: " + tipo + " | Precio: " + this.precio + "euros | Kcal: " + this.kcal + " | % de Grasa: " + this.porcentajeGrasa + "% | Edulcorante: " + this.edulcorante;
    }
}
