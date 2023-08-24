package view.old;

import exceptions.InvalidShipingCostException;
import model.Articulo;
import util.ViewUtil;

import java.util.Scanner;

public class ArticuloView {
    static Scanner teclado = new Scanner(System.in);
    public static Articulo pedirArticulo() throws InvalidShipingCostException {

        System.out.println("\nIntroduce el código de producto:");
        String codigoDeProducto = teclado.nextLine();

        System.out.println("\nIntroduce la descripción de producto:");
        String descripcion = teclado.nextLine();

        System.out.println("\nIntroduce el precio de producto:");
        double precio = ViewUtil.pedirDoubleValido();

        System.out.println("\nIntroduce el coste de gastos de envio:");
        double gastosDeEnvio = ViewUtil.pedirDoubleValido();
        ViewUtil.validateShipingCost(gastosDeEnvio);

        System.out.println("\nIntroduce el tiempo de preparacion en minutos:");
        int tiempoDePreparacion = ViewUtil.pedirIntegerValido();

        return new Articulo(codigoDeProducto,descripcion,precio,gastosDeEnvio,tiempoDePreparacion);

    }

    public static void printArticulo(Articulo articulo) {
        System.out.println("Codigo: "+articulo.getCodigo());
        System.out.println("Descripcion: "+articulo.getDescripcion());
        System.out.println("Precio: "+articulo.getPrecio());
        System.out.println("Gastos De Envio: "+articulo.getGastosDeEnvio());
        System.out.println("Tiempo De Preparacion: "+articulo.getTiempoDePreparacion());
    }
}
