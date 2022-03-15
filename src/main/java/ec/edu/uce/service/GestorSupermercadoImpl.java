package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.modelo.Producto;
import ec.edu.uce.modelo.Venta;

@Service
public class GestorSupermercadoImpl implements IGestorSupermercado {
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IVentaService ventasService;
	
	@Autowired
	private IDetalleVentaService detalleService;

	@Override
	public void ingresarProducto(Producto producto, Integer stock) {
		try {
			Producto p1 = this.productoService.buscarPorCodigoBarras(producto.getCodigoBarras());
			p1.setStock(producto.getStock() + stock);
			this.productoService.actualizar(p1);
			
		} catch (Exception e) {
			producto.setStock(stock);
			this.productoService.actualizar(producto);
		}
		
		

	}
	
	

	@Override
	@Transactional
	public void realizarVenta(List<DetalleVenta> detalles, String cedula, String numeroVenta) {
		detalles.stream().forEach(d-> {
			Venta v = new Venta();
			v.setCedulaCliente(cedula);
			v.setDetalles(detalles);
			v.setFecha(LocalDateTime.now());
			v.setNumero(numeroVenta);
			if(d.getProducto().getStock() <= d.getCantidad()) {
				throw new ArrayIndexOutOfBoundsException(); 
			}else {
			  d.setSubtotal(d.getPrecioUnitario().multiply(new BigDecimal(d.getCantidad())));
			  d.getProducto().setStock(d.getProducto().getStock()- d.getCantidad());
				
				v.setTotalVenta(v.getTotalVenta().add(d.getSubtotal()));
			}
			
			this.ventasService.insertar(v);
			
		
		});

	}

	@Override
	public void reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad) {
		List<Venta> ventas = this.ventasService.buscarTodo();
		Stream<Venta> listaVentas = ventas.stream().filter(v-> v.getFecha().compareTo(fecha)==1);
		
		

	}

	@Override
	public void reporteStock(String codigoBarras) {
		// TODO Auto-generated method stub

	}

}
