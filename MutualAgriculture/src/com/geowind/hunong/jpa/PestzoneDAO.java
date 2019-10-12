package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pestzone entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Pestzone
 * @author MyEclipse Persistence Tools
 */
public class PestzoneDAO implements IPestzoneDAO {
	// property constants
	public static final String DEGREE = "degree";
	public static final String PTYPE = "ptype";
	public static final String ITYPE = "itype";
	public static final String TIME = "time";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Pestzone entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PestzoneDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestzone entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Pestzone entity) {
		EntityManagerHelper.log("saving Pestzone instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Pestzone entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PestzoneDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Pestzone entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Pestzone entity) {
		EntityManagerHelper.log("deleting Pestzone instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Pestzone.class,
					entity.getPzid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Pestzone entity and return it or a copy of it
	 * to the sender. A copy of the Pestzone entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = PestzoneDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestzone entity to update
	 * @return Pestzone the persisted Pestzone entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Pestzone update(Pestzone entity) {
		EntityManagerHelper.log("updating Pestzone instance", Level.INFO, null);
		try {
			Pestzone result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Pestzone findById(Integer id) {
		EntityManagerHelper.log("finding Pestzone instance with id: " + id,
				Level.INFO, null);
		try {
			Pestzone instance = getEntityManager().find(Pestzone.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Pestzone entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Pestzone property to query
	 * @param value
	 *            the property value to match
	 * @return List<Pestzone> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Pestzone> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Pestzone instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Pestzone model where model."
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

	public List<Pestzone> findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List<Pestzone> findByPtype(Object ptype) {
		return findByProperty(PTYPE, ptype);
	}

	public List<Pestzone> findByItype(Object itype) {
		return findByProperty(ITYPE, itype);
	}

	public List<Pestzone> findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List<Pestzone> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/**
	 * Find all Pestzone entities.
	 * 
	 * @return List<Pestzone> all Pestzone entities
	 */
	@SuppressWarnings("unchecked")
	public List<Pestzone> findAll() {
		EntityManagerHelper.log("finding all Pestzone instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Pestzone model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}