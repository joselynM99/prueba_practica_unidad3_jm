package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.DetalleVenta;
import ec.edu.uce.modelo.Producto;

@Repository
@Transactional
public class DetalleVentaRepoImpl implements IDetalleVentaRepo {

	private static final Logger LOG = LoggerFactory.getLogger(DetalleVentaRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleVenta detalle) {
		this.entityManager.persist(detalle);

	}

	@Override
	public void actualizar(DetalleVenta detalle) {
		this.entityManager.merge(detalle);

	}

	@Override
	public DetalleVenta buscarPorID(Integer id) {
		return this.entityManager.find(DetalleVenta.class, id);
	}

	@Override
	public void borrarPorId(Integer id) {
		DetalleVenta detalleABorrar = this.buscarPorID(id);
		this.entityManager.remove(detalleABorrar);

	}
	


}
