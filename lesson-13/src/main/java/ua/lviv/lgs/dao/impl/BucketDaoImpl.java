package ua.lviv.lgs.dao.impl;

import java.awt.IllegalComponentStateException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.shared.FactoryManager;

public class BucketDaoImpl implements BucketDao {

	private static Logger LOGER = Logger.getLogger(BucketDaoImpl.class);
	private EntityManager em = FactoryManager.getEntityManager();

	@Override
	public Bucket create(Bucket bucket) {
		try {
			em.getTransaction().begin();
			em.persist(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket readById(Integer id) {
		Bucket bucket = null;
		try {
			bucket = em.find(Bucket.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bucket;
	}

	@Override
	public Bucket update(Integer id, Bucket bucket) {
		throw new IllegalComponentStateException("there is no update for bucket");
	}

	@Override
	public void delete(Integer id) {
		try {
			Bucket bucket = readById(id);
			em.getTransaction().begin();
			em.remove(bucket);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bucket> readAll() {
		Query query = null;

		try {
			query = em.createQuery("SELECT e FROM Bucket e");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return query.getResultList();
	}
}
