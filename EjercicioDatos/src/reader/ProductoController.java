package reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoController {
    private List<Producto> productos;
    private final String archivoDatos = "productos.dat";  // ruta fija del archivo

    public ProductoController() {
        productos = new ArrayList<>();
        cargarDatos();
    }

    // añadir producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarDatos();
    }

    // modificar producto
    public void modificarProducto(int codigo, Producto nuevoProducto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                productos.set(i, nuevoProducto);
                guardarDatos();
                return;
            }
        }
    }

    // eliminar producto
    public void eliminarProducto(int codigo) {
        productos.removeIf(producto -> producto.getCodigo() == codigo);
        guardarDatos();
    }

    // obtener producto por codigo
    public Producto obtenerProducto(int codigo) {
        return productos.stream().filter(p -> p.getCodigo() == codigo).findFirst().orElse(null);
    }

    // Listar productos
    public List<Producto> listarProductos() {
        return productos;
    }

    // guardar datos en fichero
    private void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDatos))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // cargar datos desde fichero
    @SuppressWarnings({ "unchecked"})
	private void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoDatos))) {
            productos = (List<Producto>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de datos no encontrado, creando uno nuevo...");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
