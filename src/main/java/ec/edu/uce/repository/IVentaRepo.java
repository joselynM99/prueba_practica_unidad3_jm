package ec.edu.uce.repository;

import ec.edu.uce.modelo.Venta;

public interface IVentaRepo {
	
	void insertar(Venta venta);

	void actualizar(Venta venta);

	Venta buscarPorID(Integer id);

	void borrarPorId(Integer id);

}
