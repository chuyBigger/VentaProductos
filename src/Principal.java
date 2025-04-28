import com.aluracursos.almacen.productos.Producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean finalizar = false; // Variable de control para terminar el ciclo
        ArrayList<Producto> listaDeProductos = new ArrayList<>();

        // Crear productos iniciales
        Producto producto1 = new Producto("Zapato", 1350.50);
        Producto producto2 = new Producto("Gansito", 25);
        Producto producto3 = new Producto("Caguama", 75);
        Producto producto4 = new Producto("Pantalón", 325.75);
        Producto producto5 = new Producto("Coca Cola", 37);

        // Agregar productos a la lista
        listaDeProductos.add(producto1);
        listaDeProductos.add(producto2);
        listaDeProductos.add(producto3);
        listaDeProductos.add(producto4);
        listaDeProductos.add(producto5);

        System.out.println("Ingrese la cantidad de crédito");
        double credito = sc.nextDouble(); // Crédito disponible para compras
        double totalCompras = 0; // Total acumulado de las compras realizadas

        System.out.println("Hola, Bienvenido al Sistema POS Mini");

        // Ciclo principal del sistema
        while (!finalizar) {
            System.out.println("\n¿Qué deseas hacer? Ingresa el número correspondiente a la opción deseada:" + """
                   \n***********************************************************************
                    1.- Ver lista de productos
                    2.- Agregar un producto
                    3.- Comprar un Producto
                    4.- Ver crédito disponible
                    5.- Total de Gastos en compras
                    6.- Salir 
                    """);
            int opcion = sc.nextInt(); // Opción seleccionada por el usuario
            sc.nextLine(); // Limpiar el buffer del Scanner

            switch (opcion) {
                case 1: {
                    // Mostrar lista de productos ordenada alfabéticamente
                    Collections.sort(listaDeProductos);
                    for (int i = 0; i < listaDeProductos.size(); i++) {
                        System.out.println(listaDeProductos.get(i)); // Mostrar nombre y precio de cada producto
                    }
                    break;
                }
                case 2: {
                    // Agregar un nuevo producto a la lista
                    boolean agregarProducto = true;

                    while (agregarProducto) {
                        System.out.println("Nombre del producto que deseas agregar: ");
                        String nombreNuevoProducto = sc.nextLine(); // Leer nombre del producto
                        System.out.println("Precio del producto que agregaste:");
                        double precioNuevoProducto = sc.nextDouble(); // Leer precio del producto

                        Producto nuevoProducto = new Producto(nombreNuevoProducto, precioNuevoProducto);
                        listaDeProductos.add(nuevoProducto); // Agregar producto a la lista

                        System.out.println("¿Deseas agregar otro producto?");
                        System.out.println("1.- Sí \n2.- No");
                        int respuesta = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer

                        if (respuesta == 1) {
                            continue; // Volver a pedir otro producto
                        } else if (respuesta == 2) {
                            agregarProducto = false; // Terminar el ciclo de agregar productos
                        } else {
                            System.out.println("El valor ingresado no es correcto. Vuelve a intentarlo.");
                        }
                    }
                    break;
                }
                case 3: {
                    // Lógica de compra de un producto
                    boolean realizarCompra = false;
                    while (!realizarCompra) {
                        if (credito >= 0) { // Verificar si hay crédito disponible
                            System.out.println("¿Qué producto deseas comprar?");
                            String nombreProductoCompra = sc.nextLine(); // Leer el nombre del producto a comprar
                            boolean productoEncontrado = false;

                            for (Producto prod : listaDeProductos) { // Buscar el producto
                                if (prod.getNombre().equalsIgnoreCase(nombreProductoCompra)) {
                                    // Verificar si el crédito es suficiente para comprar el producto
                                    double cobro = prod.getPrecio();
                                    if (cobro <= credito) {
                                        credito -= cobro; // Actualizar el crédito disponible
                                        System.out.println("""
                                                ***************************************************
                                                *********************** Ticket ********************
                                                ---------------------------------------------------
                                                Producto: """ + prod.getNombre() + "\n Precio: " + cobro +
                                                "\n Saldo disponible: " + credito + " \n " +
                                                """
                                                ***************************************************
                                                *********************** GRACIAS... ****************
                                                ---------------------------------------------------
                                                """);
                                        totalCompras += cobro; // Actualizar total de compras
                                        productoEncontrado = true;
                                    } else {
                                        System.out.println("No tienes suficiente crédito para realizar la compra.");
                                        System.out.println("Presiona una tecla para continuar...");
                                        sc.nextLine();
                                        realizarCompra = true;
                                    }

                                    // Preguntar si el usuario desea realizar otra compra
                                    System.out.println("""
                                        ¿Deseas hacer otra compra? 
                                        1.- Sí 
                                        2.- No
                                        """);
                                    int nuevaCompra = sc.nextInt();
                                    sc.nextLine(); // Limpiar buffer

                                    if (nuevaCompra == 1) {
                                        System.out.println("Vuelve a comprar");
                                    } else {
                                        realizarCompra = true; // Terminar la compra
                                        break;
                                    }
                                }
                            }
                            if (!productoEncontrado) {
                                System.out.println("El producto no está disponible o el nombre ingresado es incorrecto.");
                                System.out.println("Vuelve a intentarlo...");
                            }
                        } else {
                            System.out.println("No tienes crédito suficiente para comprar.");
                            realizarCompra = true;
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    // Verificar el crédito disponible
                    System.out.println("El crédito disponible es: " + credito);
                    break;
                }
                case 5: {
                    // Mostrar el total de las compras realizadas
                    System.out.println("El total de gasto de hoy es: " + totalCompras);
                    break;
                }
                case 6: {
                    // Salir del programa
                    System.out.println("El programa ha terminado. ¡Gracias por usarlo!");
                    finalizar = true;
                    break;
                }
                default: {
                    // Opción no válida
                    System.out.println("Ha ingresado un valor incorrecto. Por favor, vuelva a intentarlo.");
                }
            }
        }
    }
}