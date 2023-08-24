package view.old;

import model.Cliente;
import util.ViewUtil;

import java.util.Scanner;

import static util.ViewUtil.pedirDoubleValido;

public class ClienteView {

    static Scanner teclado = new Scanner(System.in);
    public static int pedirTipoCliente()  {
        System.out.println("\nIntroduce 1 para crear un cliente Estandar y 2 para un cliente Premium:");

        int num = Integer.MIN_VALUE;
        String msg1;
        do {
            msg1 = "\nElige una opción valida: ";
            num = ViewUtil.validarInteger(msg1);
        } while (num <= 0 || num > 2);

       return num;
    }

    public static Cliente pedirClienteEstandar() {
        
        System.out.println("\nIntroduce el nombre:");
        String nombre = teclado.nextLine();

        System.out.println("\nIntroduce el domicilio:");
        String domicilio = teclado.nextLine();

        String nif = ViewUtil.pedirNIFValido();

        System.out.println("\nIntroduce el email:");
        String email = teclado.nextLine();


        System.out.println("\nIntroduce el teléfono:");
        String telefono = teclado.nextLine();

        return new Cliente(nombre,domicilio,nif,email,telefono,0);
    }

    public static Cliente pedirClientePremium() {

        System.out.println("\nIntroduce el nombre:");
        String nombre = teclado.nextLine();

        System.out.println("\nIntroduce el domicilio:");
        String domicilio = teclado.nextLine();

        String nif = ViewUtil.pedirNIFValido();

        System.out.println("\nIntroduce el email:");
        String email = teclado.nextLine();

        System.out.println("\nIntroduce el teléfono:");
        String telefono = teclado.nextLine();


        System.out.println("\nIntroduce la cuota anual:");
        double cuota = pedirDoubleValido();

        System.out.println("\nIntroduce el descuento:");
        double descuento = pedirDoubleValido();

        return new Cliente(nombre,domicilio,nif,email,telefono,1,cuota,descuento);

    }

    public static void printClientePremium(Cliente clientePremium) {
        System.out.println("Cliente Premium");
        System.out.println("Nombre: "+clientePremium.getNombre());
        System.out.println("Domicilio: "+clientePremium.getDomicilio());
        System.out.println("NIF: "+clientePremium.getNif());
        System.out.println("Email: "+clientePremium.getEmail());
        System.out.println("Teléfono: "+clientePremium.getTelefono());
        System.out.println("Cuota anual: "+clientePremium.getCuota());
        System.out.println("Descuento gastos de envio: "+clientePremium.getDescuento());
    }

    public static void printClienteEstandar(Cliente clienteEstandar) {
        System.out.println("Cliente Estandar");
        System.out.println("Nombre: "+clienteEstandar.getNombre());
        System.out.println("Domicilio: "+clienteEstandar.getDomicilio());
        System.out.println("NIF: "+clienteEstandar.getNif());
        System.out.println("Email: "+clienteEstandar.getEmail());
        System.out.println("Teléfono: "+clienteEstandar.getTelefono());
    }
}
