package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Producto;

@Repository
@Transactional
public class ProductoRepoImpl implements IProductoRepo {

	private static final Logger LOG = LoggerFactory.getLogger(ProductoRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);

	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);

	}

	@Override
	public Producto buscarPorID(Integer id) {
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void borrarPorId(Integer id) {
		Producto productoABorrar = this.buscarPorID(id);
		this.entityManager.remove(productoABorrar);

	}
	
	@Override
	public Producto buscarPorCodigoBarras(String codigo) {
		TypedQuery<Producto> myTypedQuery = this.entityManager
				.createQuery("select p from Producto p where p.codigoBarras =:valor", Producto.class);
		myTypedQuery.setParameter("valor", codigo);
		
		return myTypedQuery.getSingleResult();
	}

}
