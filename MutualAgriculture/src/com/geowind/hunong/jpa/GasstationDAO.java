package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Gasstation entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Gasstation
 * @author MyEclipse Persistence Tools
 */
public class GasstationDAO implements IGasstationDAO {
	// property constants
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Gasstation entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * GasstationDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Gasstation entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Gasstation entity) {
		EntityManagerHelper.log("saving Gasstation instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Gasstation entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * GasstationDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Gasstation entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Gasstation entity) {
		EntityManagerHelper.log("deleting Gasstation instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Gasstation.class,
					entity.getGid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Gasstation entity and return it or a copy of
	 * it to the sender. A copy of the Gasstation entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = GasstationDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Gasstation entity to update
	 * @return Gasstation the persisted Gasstation entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Gasstation update(Gasstation entity) {
		EntityManagerHelper.log("updating Gasstation instance", Level.INFO,
				null);
		try {
			Gasstation result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Gasstation findById(Integer id) {
		EntityManagerHelper.log("finding Gasstation instance with id: " + id,
				Level.INFO, null);
		try {
			Gasstation instance = getEntityManager().find(Gasstation.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Gasstation entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Gasstation property to query
	 * @param value
	 *            the property value to match
	 * @return List<Gasstation> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Gasstation> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding Gasstation instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Gasstation model where model."
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

	public List<Gasstation> findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List<Gasstation> findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	/**
	 * Find all Gasstation entities.
	 * 
	 * @return List<Gasstation> all Gasstation entities
	 */
	@SuppressWarnings("unchecked")
	public List<Gasstation> findAll() {
		EntityManagerHelper.log("finding all Gasstation instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Gasstation model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}