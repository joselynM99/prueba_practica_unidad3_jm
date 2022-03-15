package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Venta;
import ec.edu.uce.repository.IVentaRepo;

@Service
public class VentaServiceImpl implements IVentaService{
	
	@Autowired
	private IVentaRepo ventaRepo;

	@Override
	public void insertar(Venta venta) {
		this.ventaRepo.insertar(venta);
		
	}

	@Override
	public void actualizar(Venta venta) {
		this.ventaRepo.actualizar(venta);
		
	}

	@Override
	public Venta buscarPorID(Integer id) {
		return this.ventaRepo.buscarPorID(id);
	}

	@Override
	public void borrarPorId(Integer id) {
		this.ventaRepo.borrarPorId(id);
		
	}
	
	

}
