package ejercicio01.cuentaCorriente;
import java.util.Scanner;
import java.io.IOException;

public class TestCuenta {

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        Cuenta cuenta1 = new Cuenta("ES2125145700", 9000, "GARA");
        Cuenta cuenta2 = new Cuenta("ES2125145701", 1, "CRISTHIAN"); // CREO EL OBJETO DE CLASE CUENTA.
    
        Cuenta[] listadoCuenta = new Cuenta[2];
        listadoCuenta[0] = cuenta1;
        listadoCuenta[1] = cuenta2;

        do {
            System.out.println("1- Consultar saldo.");
            System.out.println("2- Ingresar dinero. ");
            System.out.println("3- Sacar dinero.");
            System.out.println("4- Realizar transferencia.");
            System.out.println("5- Salir.");

                opcion = Utilidades.pideEntero("Introduzca la operación a realizar de las anteriores: ", entrada);

            switch (opcion) {
                case 1:
                    consultarSaldo(listadoCuenta, entrada);
                    break;
                case 2:
                    ingresarSaldo(listadoCuenta, entrada);
                    break;
                case 3:
                    sacarDinero(listadoCuenta, entrada);
                    break;
                case 4:
                    transferencia(listadoCuenta, entrada);
                    break;
                case 5:
                    System.out.println("ADIÓS");
                    break;    
                default:
                    System.out.println("Ha introducido un valor incorrecto, por favor inserte de nuevo");
            }

        } while (opcion != 5);
        entrada.close();
    }

    // mostrarCuentas llamando al metodo mostrarInfo que esta en la clase Cuenta. Desde el objeto cuenta accedemos a ella.  
    public static void mostrarCuentas(Cuenta[] listadoCuenta) throws IOException { 
        
        for(int i=0; i<listadoCuenta.length; i++){
            System.out.println("* Cuenta " + i + " *");
            listadoCuenta[i].mostrarInfo();
        }
    }

    public static void consultarSaldo(Cuenta[] listadoCuenta, Scanner entrada) throws IOException { 
        
        mostrarCuentas(listadoCuenta);
        int posicionCuenta = 0;
        do{
            posicionCuenta = Utilidades.pideEntero("Introduzca la posición de la cuenta que quiere consultar (0 o 1) ", entrada);
        }while(posicionCuenta != 0 && posicionCuenta != 1 ); 
        System.out.println("El saldo de la cuenta " + listadoCuenta[posicionCuenta].getNumCuenta() + " es " + listadoCuenta[posicionCuenta]. () + " euros ");
    }

    public static void ingresarSaldo(Cuenta[] listadoCuenta, Scanner entrada) throws IOException { 
        
        mostrarCuentas(listadoCuenta);
        int posicionCuenta = 0;
        do{
            posicionCuenta = Utilidades.pideEntero("Introduzca la posición de la cuenta a la que quiere ingresar dinero (0 o 1) ", entrada);
        }while(posicionCuenta != 0 && posicionCuenta != 1 );

        double ingreso = 0;
        do{
            ingreso = Utilidades.pideDecimal("Introduzca la cantidad de dinero que desea ingresar ", entrada);
        }while(ingreso<0);

        double total = listadoCuenta[posicionCuenta].getSaldo() + ingreso;
        listadoCuenta[posicionCuenta].setSaldo(total);
        System.out.println("El saldo de la cuenta " + listadoCuenta[posicionCuenta].getNumCuenta() + " es " + listadoCuenta[posicionCuenta].getSaldo() + " euros ");
    }

    public static void sacarDinero(Cuenta[] listadoCuenta, Scanner entrada) throws IOException { 
        
        mostrarCuentas(listadoCuenta);
        int posicionCuenta = 0;
        do{
            posicionCuenta = Utilidades.pideEntero("Introduzca la posición de la cuenta a la que quiere ingresar dinero (0 o 1) ", entrada);
        }while(posicionCuenta != 0 && posicionCuenta != 1 );

        double retirada = 0;
        do{
            retirada = Utilidades.pideDecimal("Introduzca la cantidad de dinero que desea retirar ", entrada);
        }while(listadoCuenta[posicionCuenta].getSaldo() < retirada);

        double total = listadoCuenta[posicionCuenta].getSaldo() - retirada;
        listadoCuenta[posicionCuenta].setSaldo(total);
        System.out.println("El saldo de la cuenta " + listadoCuenta[posicionCuenta].getNumCuenta() + " es " + listadoCuenta[posicionCuenta].getSaldo() + " euros ");
    }

    public static void transferencia(Cuenta[] listadoCuenta, Scanner entrada) throws IOException { 
        
        mostrarCuentas(listadoCuenta);
        int cuentaOrigen = 0;
        do{
            cuentaOrigen = Utilidades.pideEntero("Introduzca la posicion de la cuenta de origen para retirar dinero (0 o 1) ", entrada);
        }while(cuentaOrigen != 0 && cuentaOrigen != 1);

        int cuentaDestino = 0;
        do{
            cuentaDestino = Utilidades.pideEntero("Introduzca la posicion de la cuenta de destino para ingresar dinero (0 o 1) ", entrada);
        }while(cuentaDestino != 0 && cuentaDestino != 1);

        double transferencia = 0;
        do{
            transferencia = Utilidades.pideDecimal("Introduzca la cantidad de dinero que desea transferir ", entrada);
        }while(listadoCuenta[cuentaOrigen].getSaldo() < transferencia);

        double retirada = listadoCuenta[cuentaOrigen].getSaldo() - transferencia;
        listadoCuenta[cuentaOrigen].setSaldo(retirada);

        double ingreso = listadoCuenta[cuentaDestino].getSaldo() + transferencia;
        listadoCuenta[cuentaDestino].setSaldo(ingreso);

        System.out.println("El saldo de la cuenta " + listadoCuenta[cuentaOrigen].getNumCuenta() + " es " + listadoCuenta[cuentaOrigen].getSaldo() + " euros ");
        System.out.println("El saldo de la cuenta " + listadoCuenta[cuentaDestino].getNumCuenta() + " es " + listadoCuenta[cuentaDestino].getSaldo() + " euros ");
    }
}