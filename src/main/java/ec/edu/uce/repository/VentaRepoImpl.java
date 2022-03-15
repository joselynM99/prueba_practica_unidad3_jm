package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Producto;
import ec.edu.uce.modelo.Venta;

@Repository
@Transactional
public class VentaRepoImpl implements IVentaRepo {

	private static final Logger LOG = LoggerFactory.getLogger(VentaRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Venta venta) {
		this.entityManager.persist(venta);

	}

	@Override
	public void actualizar(Venta venta) {
		this.entityManager.merge(venta);

	}

	@Override
	public Venta buscarPorID(Integer id) {
		return this.entityManager.find(Venta.class, id);
	}

	@Override
	public void borrarPorId(Integer id) {
		Venta ventaABorrar= this.buscarPorID(id);
		this.entityManager.remove(ventaABorrar);

	}
	
	@Override
	public List<Venta> buscarTodo() {
		TypedQuery<Venta> myTypedQuery = this.entityManager
				.createQuery("select v from Venta v", Venta.class);
		
		return myTypedQuery.getResultList();
		
	}

}
