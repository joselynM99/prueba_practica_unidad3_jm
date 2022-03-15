package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Producto;

public interface IGestorSupermercado {
	void ingresarProducto(Producto producto, Integer stock);
	
	List<Producto> crearListaProductos(String codigoBarras, Integer cantidad);
	
	void realizarVenta(List<Producto> productos, String cedula, String numeroVenta);
	
	void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);
}
