package ec.edu.uce;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Producto;
import ec.edu.uce.service.IGestorSupermercado;
import ec.edu.uce.service.IProductoService;

@SpringBootApplication
public class PruebaUnidad3JmApplication implements CommandLineRunner{
	
	@Autowired
	private IGestorSupermercado supermercado;
	
	@Autowired
	private IProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3JmApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Producto p1 = new Producto();
		p1.setCategoria("Aseo");
		p1.setCodigoBarras("48233335555");
		p1.setNombre("Papel higenico FM");
		p1.setPrecio(new BigDecimal(2.0));
		
		
//		this.productoService.insertar(p1);
//		this.supermercado.ingresarProducto(p1, 20);
	}

}
