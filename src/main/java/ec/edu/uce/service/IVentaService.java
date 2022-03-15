package ec.edu.uce.service;

import ec.edu.uce.modelo.Venta;

public interface IVentaService {
	
	void insertar(Venta venta);

	void actualizar(Venta venta);

	Venta buscarPorID(Integer id);

	void borrarPorId(Integer id);

}
