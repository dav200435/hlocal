package reader;

import java.util.List;
import java.util.Scanner;

public class ProductoView {
    private static ProductoController controller = new ProductoController();
    private static Scanner scanner = new Scanner(System.in);

    public void menu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    modificarProducto();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    listarProductos();
                    break;
                case 5:
                    buscarProducto();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            if (opcion != 0) {
                
                System.out.println("\nPresiona Enter para continuar...");
                scanner.nextLine();

				for (int i=0;i<50;i++) {
					System.out.println(" ");
				}
				
            }

        } while (opcion != 0);
    }

    //mostrar menu
    private static void mostrarMenu() {
        System.out.println("--------- Menu ---------");
        System.out.println("1. Agregar producto");
        System.out.println("2. Modificar producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Listar productos");
        System.out.println("5. Buscar producto por codigo");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    //agregar producto
    private static void agregarProducto() {
        System.out.println("Agregar nuevo producto:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Código: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ruta de imagen: ");
        String rutaImagen = scanner.nextLine();

        Producto producto = new Producto(nombre, codigo, precio, descripcion, rutaImagen);
        controller.agregarProducto(producto);

        System.out.println("Producto agregado con exito.");
    }

    //modificar producto
    private static void modificarProducto() {
        System.out.print("Introduce el codigo del producto a modificar: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Producto productoExistente = controller.obtenerProducto(codigo);
        if (productoExistente != null) {
            System.out.println("Producto encontrado: " + productoExistente);
            
            System.out.print("Nuevo nombre (deja en blanco para no cambiar): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                productoExistente.setNombre(nuevoNombre);
            }

            System.out.print("Nuevo precio (deja en blanco para no cambiar): ");
            String nuevoPrecio = scanner.nextLine();
            if (!nuevoPrecio.isEmpty()) {
                productoExistente.setPrecio(Double.parseDouble(nuevoPrecio));
            }

            System.out.print("Nueva descripción (deja en blanco para no cambiar): ");
            String nuevaDescripcion = scanner.nextLine();
            if (!nuevaDescripcion.isEmpty()) {
                productoExistente.setDescripcion(nuevaDescripcion);
            }

            System.out.print("Nueva ruta de imagen (deja en blanco para no cambiar): ");
            String nuevaRutaImagen = scanner.nextLine();
            if (!nuevaRutaImagen.isEmpty()) {
                productoExistente.setRutaImagen(nuevaRutaImagen);
            }

            controller.modificarProducto(codigo, productoExistente);
            System.out.println("Producto modificado con exito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    //eliminar  producto
    private static void eliminarProducto() {
        System.out.print("Introduce el codigo del producto a eliminar: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        controller.eliminarProducto(codigo);
        System.out.println("Producto eliminado.");
    }

    //listar 
    private static void listarProductos() {
        System.out.println("Listado de productos:");
        List<Producto> productos = controller.listarProductos();
        if (productos.isEmpty()) {
            System.out.println("No hay productos.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    // buscar producto por codigo
    private static void buscarProducto() {
        System.out.print("Introduce el codigo del producto: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        Producto producto = controller.obtenerProducto(codigo);
        if (producto != null) {
            System.out.println("Producto encontrado: " + producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
