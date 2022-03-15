package ec.edu.uce.repository;

import ec.edu.uce.modelo.Producto;

public interface IProductoRepo {

	void insertar(Producto producto);

	void actualizar(Producto producto);

	Producto buscarPorID(Integer id);

	void borrarPorId(Integer id);

	Producto buscarPorCodigoBarras(String codigo);

}
