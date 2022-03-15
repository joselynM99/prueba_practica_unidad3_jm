package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.repository.IDetalleVentaRepo;

@Service
public class DetalleVentaServiceImpl implements IDetalleVentaService{
	
	@Autowired
	private IDetalleVentaRepo detalleRepo;

	@Override
	public void insertar(DetalleVenta detalle) {
		this.detalleRepo.insertar(detalle);
		
	}

	@Override
	public void actualizar(DetalleVenta detalle) {
		this.detalleRepo.actualizar(detalle);
		
	}

	@Override
	public DetalleVenta buscarPorID(Integer id) {
		return this.detalleRepo.buscarPorID(id);
	}

	@Override
	public void borrarPorId(Integer id) {
		this.detalleRepo.borrarPorId(id);
		
	}

}
