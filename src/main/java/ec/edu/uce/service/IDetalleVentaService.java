package ec.edu.uce.service;

import ec.edu.uce.modelo.DetalleVenta;

public interface IDetalleVentaService {
	
	void insertar(DetalleVenta detalle);

	void actualizar(DetalleVenta detalle);

	DetalleVenta buscarPorID(Integer id);

	void borrarPorId(Integer id);

}
