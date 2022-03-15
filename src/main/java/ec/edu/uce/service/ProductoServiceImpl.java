package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Producto;
import ec.edu.uce.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public void insertar(Producto producto) {
		this.productoRepo.insertar(producto);

	}

	@Override
	public void actualizar(Producto producto) {
		this.productoRepo.actualizar(producto);

	}

	@Override
	public Producto buscarPorID(Integer id) {
		return this.productoRepo.buscarPorID(id);
	}

	@Override
	public void borrarPorId(Integer id) {
		this.productoRepo.borrarPorId(id);

	}

	@Override
	public Producto buscarPorCodigoBarras(String codigo) {

		return this.productoRepo.buscarPorCodigoBarras(codigo);
	}

}
