package ec.edu.uce.repository;

import ec.edu.uce.modelo.DetalleVenta;

public interface IDetalleVentaRepo {
	
	void insertar(DetalleVenta detalle);

	void actualizar(DetalleVenta detalle);

	DetalleVenta buscarPorID(Integer id);

	void borrarPorId(Integer id);

}
