package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Venta;

public interface IVentaService {
	
	void insertar(Venta venta);

	void actualizar(Venta venta);

	Venta buscarPorID(Integer id);

	void borrarPorId(Integer id);

	List<Venta> buscarTodo();

}
