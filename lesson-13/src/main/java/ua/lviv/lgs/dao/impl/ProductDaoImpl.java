package ua.lviv.lgs.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.shared.FactoryManager;

public class ProductDaoImpl implements ProductDao {

	private static Logger LOGER = Logger.getLogger(ProductDaoImpl.class);
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Product create(Product product) {
		try {
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product readById(Integer id) {
		Product product = null;
		try {
			product = em.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product update(Integer id, Product product) {
		try {
			// not used
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			// not used
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> readAll() {
		Query query = null;

		try {
			query = em.createQuery("SELECT e FROM Product e");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return query.getResultList();
	}
}
