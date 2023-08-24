package view.old;

import exceptions.InvalidShipingCostException;
import util.ViewUtil;

import java.util.Scanner;

public class OnlineStoreView {
    static Scanner teclado = new Scanner(System.in);
    public static int inicio(){

        int opcio;
        int respuesta = Integer.MIN_VALUE;;
        System.out.println("Online Store");


            System.out.println("\nQue desea hacer?");
            System.out.println("1. Gestionar Artículos");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Gestionar Pedidos");
            System.out.println("0. Salir de la aplicación");
            opcio = pedirOpcion();
            switch (opcio) {
                case 1:
                    System.out.println("\n**************** 1. Gestionar Artículos *****************\n");

                        System.out.println("\nQue desea hacer?");
                        System.out.println("1. Añadir Articulo");
                        System.out.println("2. Mostrar Artículos");
                        System.out.println("0. Salir de la aplicación");
                        opcio = pedirOpcion();
                        switch (opcio) {
                            case 1:
                                System.out.println("\n**************** 1. Añadir Articulo *****************\n");
                                respuesta = 1;
                                break;
                            case 2:
                                System.out.println("\n**************** 2. Mostrar Artículos *****************\n");
                                respuesta = 2;
                                break;

                            case 0:
                                System.out.println("\n****************  Hasta pronto !!! *****************\n");
                                System.exit(1);
                                break;
                        }
                    break;
                case 2:
                    System.out.println("\n**************** 2. Gestionar Clientes *****************\n");

                        System.out.println("\nQue desea hacer?");
                        System.out.println("1. Añadir Cliente");
                        System.out.println("2. Mostrar Todos los Clientes");
                        System.out.println("3. Mostrar Clientes Estandar");
                        System.out.println("4. Mostrar Clientes Premium");
                        System.out.println("0. Salir de la aplicación");
                        opcio = pedirOpcion();
                        switch (opcio) {
                            case 1:
                                System.out.println("\n**************** 1. Añadir Cliente *****************\n");//
                                respuesta = 3;
                                break;
                            case 2:
                                System.out.println("\n**************** 2. Mostrar Todos los Clientes *****************\n");
                                respuesta = 4;
                                break;
                            case 3:
                                System.out.println("\n**************** 3. Mostrar Clientes Estandar *****************\n");
                                respuesta = 5;
                                break;
                            case 4:
                                System.out.println("\n**************** 2. Mostrar Clientes Premium *****************\n");
                                respuesta = 6;
                                break;

                            case 0:
                                System.out.println("\n****************  Hasta pronto !!! *****************\n");
                                System.exit(1);
                                break;
                        }
                    break;
                case 3:
                    System.out.println("\n**************** 3. Gestionar Pedidos *****************\n");

                        System.out.println("\nQue desea hacer?");
                        System.out.println("1. Añadir Pedido");
                        System.out.println("2. Eliminar Pedido");
                        System.out.println("3. Mostrar Pedidos Enviados");
                        System.out.println("4. Mostar pedidos pendientes de envío");
                        System.out.println("0. Salir de la aplicación");

                        opcio = pedirOpcion();
                        switch (opcio) {
                            case 1:
                                System.out.println("\n**************** 1. Añadir Pedido *****************\n");
                                respuesta = 7;
                                break;
                            case 2:
                                System.out.println("\n**************** 2. Eliminar Pedido *****************\n");
                                respuesta = 8;
                                break;
                            case 3:
                                System.out.println("\n**************** 2. Mostrar Pedidos Enviados *****************\n");
                                respuesta = 9;
                                break;
                            case 4:
                                System.out.println("\n**************** 3. Mostar pedidos pendientes de envío *****************\n");
                                respuesta = 10;
                                break;
                            case 0:
                                System.out.println("\n****************  Hasta pronto !!! *****************\n");
                                System.exit(1);
                                break;
                        }
                    break;
                case 0:
                    System.out.println("\n****************  Hasta pronto !!! *****************\n");
                    System.exit(1);
                    break;
            }
        return respuesta;
    }

    public static int pedirOpcion() {
        int resp = Integer.MIN_VALUE;
        String msg1;
        do {
            msg1 = "\nElige una opción valida: ";
            resp = ViewUtil.validarInteger(msg1);
        } while (resp < 0 || resp > 4);

        return resp;
    }


    public static boolean deseaHacerAlgoMas() throws InvalidShipingCostException {
        boolean salir = false;
        System.out.println("\nDesea hacer algo mas? (S/N):");
        char key = teclado.nextLine().charAt(0);
        while (key != 'n' && key != 'N' && key != 's' && key != 'S') {
            System.out.println("\nDesea hacer algo mas? (S/N):");
            key = teclado.nextLine().charAt(0);
            System.out.println();
        }

        if (key == 'n' || key == 'N') {
            salir = true;
        }
        return salir;
    }


}
