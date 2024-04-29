package ejercicio02;
import java.util.Scanner;

public class Heladeria {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner entrada = new Scanner(System.in);

        Vendible[] pedido = new Vendible[4];
        pedido[0] = new Loteria(3.5, "119383939");
        pedido[1] = new Horchata("Horchata 1", 2.5, 20, 250, 30);
        pedido[2] = new Cucurucho("Cucurucho de Galleta", 1, 20, 2);
        ((Cucurucho) pedido[2]).addBolaHelado("Helado de Vainilla", 1, 30, "azúcar", 15, 0);
        ((Cucurucho) pedido[2]).addBolaHelado("Helado de Chocolate", 1, 15, "aspartamo", 15, 1);
        pedido[3] = new Cucurucho("Cucurucho de Chocolate", 1.5, 25, 2);
        ((Cucurucho) pedido[3]).addBolaHelado("Helado de Cookies", 1, 35, "azúcar", 20, 0);
        ((Cucurucho) pedido[3]).addBolaHelado("Helado de Fresa", 1, 10, "aspartamo", 5, 1);
        verPedido(pedido);

        do {
            System.out.println();
            System.out.println("Quieres hacer alguna otra operación?");
            System.out.println("1. Sustituye un pedido por una horchata");
            System.out.println("2. Ver el pedido actual");
            System.out.println("0. Salir");

            opcion = Pregunta.pideEntero("Introduzca la operación que desea realizar: ", entrada);

            switch (opcion) {
                case 1:
                    modificarPedido(pedido, entrada);
                    break;
                case 2:
                    verPedido(pedido);
                    break;
                case 0:
                    System.out.println("Adiós!! :)");
                    System.out.println();
                    break;
                default:
                    System.out.println("Ha introducido un valor incorrecto, por favor inserte de nuevo");
                    System.out.println();
            }

        } while (opcion != 0);
        entrada.close();
    }

    public static void verPedido(Vendible[] pedido) {  
        double precio = 0;
        System.out.println("Infomación del pedido: ");
        for (int i=0; i<pedido.length; i++) {
            System.out.println(i + ". " + pedido[i]);
            precio += pedido[i].getPrecio();
        }
        System.out.println("El coste total del pedido es de: " + precio + "euros");
        System.out.println();
    }

    public static void modificarPedido(Vendible[] pedido, Scanner entrada) {
        int posicion = 0;
        do{
            posicion = Pregunta.pideEntero("Indica el número de producto del pedido a modificar (entre 0 y " + (pedido.length-1) + "): ", entrada);
        }while(posicion < 0 || posicion >= pedido.length);

        System.out.println("Introduzca el nombre de la horchata: ");
        String nombre = entrada.nextLine();

        double precio = 0;
        do{
            precio = Pregunta.pideDouble("Introduzca el precio de la horchata: ", entrada);
        }while(precio < 0);

        double kcal = 0;
        do{
            kcal = Pregunta.pideDouble("Introduzca las Kcal de la horchata: ", entrada);
        }while(kcal < 0);

        double cantidad = 0;
        do{
            cantidad = Pregunta.pideDouble("Introduzca la cantidad de horchata: ", entrada);
        }while(cantidad < 0);

        double porcentajeChufa = 0;
        do{
            porcentajeChufa = Pregunta.pideDouble("Introduzca el % de chufa de la horchata: ", entrada);
        }while(porcentajeChufa < 0);

        Horchata horchata = new Horchata(nombre, precio, kcal, cantidad, porcentajeChufa);
        pedido[posicion] = horchata;
        System.out.println("El pedido se ha modificado correctamente!");
        System.out.println();        
    }
}
