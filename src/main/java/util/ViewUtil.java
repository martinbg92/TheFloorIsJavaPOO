package util;

import exceptions.InvalidShipingCostException;

import java.util.Scanner;

public class ViewUtil {
    static Scanner teclado = new Scanner(System.in);
    public static int validarInteger(String string) {
        int paraDevolver = Integer.MIN_VALUE;
        do try {
            System.out.println(string);
            paraDevolver = Integer.parseInt(teclado.nextLine());

        } catch (NumberFormatException e) {
            System.err.println("Introduce un numero valido. " + e.getMessage());
        } while (paraDevolver == Integer.MIN_VALUE);
        return paraDevolver;

    }

    public static void validateShipingCost(double cost) throws InvalidShipingCostException {
        if(cost <= 0){

            // throw an object of user defined exception
            throw new InvalidShipingCostException("Los gastos de envio tienen que ser mayor que 0 ");
        }
        else {
            System.out.println("Los vastos de envio son correctos");
        }

    }

    public static int pedirIntegerValido() {

        int resp = Integer.MIN_VALUE;

        do try {
            System.out.println("\nElige una opción valida: ");
            resp = Integer.parseInt(teclado.nextLine());

        } catch (NumberFormatException e) {
            System.err.println("Introduce un numero valido mayor que cero. " + e.getMessage());
        } while (resp <= 0);


        return resp;
    }

    public static String pedirNIFValido() {

        String nif = "";
        System.out.println("\nIntroduce el NIF(Una letra y 8 numeros). ");
        do{
            System.out.println("\nIntroduce un NIF valido(Una letra y 8 numeros). ");
            nif = teclado.nextLine();
        } while (nif.length() != 9);

        return nif;
    }

    public static double pedirDoubleValido() {
        double resp = Double.MIN_VALUE;

        do try {
            System.out.println("\nElige una opción valida: ");
            resp = Double.parseDouble(teclado.nextLine());

        } catch (NumberFormatException e) {
            System.err.println("Introduce un numero valido mayor que cero. " + e.getMessage());
        } while (resp == Double.MIN_VALUE);

        return resp;

    }
}
