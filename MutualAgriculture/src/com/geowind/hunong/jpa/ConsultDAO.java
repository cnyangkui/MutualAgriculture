package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Consult entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Consult
 * @author MyEclipse Persistence Tools
 */
public class ConsultDAO implements IConsultDAO {
	// property constants
	public static final String CCONTENT = "ccontent";
	public static final String CTIME = "ctime";
	public static final String ACONTENT = "acontent";
	public static final String KEYWORDS = "keywords";
	public static final String ATIME = "atime";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Consult entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ConsultDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Consult entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Consult entity) {
		EntityManagerHelper.log("saving Consult instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Consult entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ConsultDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Consult entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Consult entity) {
		EntityManagerHelper.log("deleting Consult instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Consult.class,
					entity.getCid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Consult entity and return it or a copy of it
	 * to the sender. A copy of the Consult entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ConsultDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Consult entity to update
	 * @return Consult the persisted Consult entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Consult update(Consult entity) {
		EntityManagerHelper.log("updating Consult instance", Level.INFO, null);
		try {
			Consult result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Consult findById(Integer id) {
		EntityManagerHelper.log("finding Consult instance with id: " + id,
				Level.INFO, null);
		try {
			Consult instance = getEntityManager().find(Consult.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Consult entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Consult property to query
	 * @param value
	 *            the property value to match
	 * @return List<Consult> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Consult> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Consult instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Consult model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<Consult> findByCcontent(Object ccontent) {
		return findByProperty(CCONTENT, ccontent);
	}

	public List<Consult> findByCtime(Object ctime) {
		return findByProperty(CTIME, ctime);
	}

	public List<Consult> findByAcontent(Object acontent) {
		return findByProperty(ACONTENT, acontent);
	}

	public List<Consult> findByKeywords(Object keywords) {
		return findByProperty(KEYWORDS, keywords);
	}

	public List<Consult> findByAtime(Object atime) {
		return findByProperty(ATIME, atime);
	}

	public List<Consult> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/**
	 * Find all Consult entities.
	 * 
	 * @return List<Consult> all Consult entities
	 */
	@SuppressWarnings("unchecked")
	public List<Consult> findAll() {
		EntityManagerHelper.log("finding all Consult instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Consult model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}