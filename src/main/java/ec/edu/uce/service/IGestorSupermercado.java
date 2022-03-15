package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.modelo.Producto;

public interface IGestorSupermercado {
	void ingresarProducto(Producto producto, Integer stock);

	void realizarVenta(List<DetalleVenta> detalles, String cedula, String numeroVenta);

	void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);

	void reporteStock(String codigoBarras);
}
