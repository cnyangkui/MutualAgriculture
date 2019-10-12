package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Servicestation entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Servicestation
 * @author MyEclipse Persistence Tools
 */
public class ServicestationDAO implements IServicestationDAO {
	// property constants
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String SPNAME = "spname";
	public static final String SPTEL = "sptel";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Servicestation entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ServicestationDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Servicestation entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Servicestation entity) {
		EntityManagerHelper.log("saving Servicestation instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Servicestation entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ServicestationDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Servicestation entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Servicestation entity) {
		EntityManagerHelper.log("deleting Servicestation instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Servicestation.class,
					entity.getSid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Servicestation entity and return it or a copy
	 * of it to the sender. A copy of the Servicestation entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ServicestationDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Servicestation entity to update
	 * @return Servicestation the persisted Servicestation entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Servicestation update(Servicestation entity) {
		EntityManagerHelper.log("updating Servicestation instance", Level.INFO,
				null);
		try {
			Servicestation result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Servicestation findById(Integer id) {
		EntityManagerHelper.log("finding Servicestation instance with id: "
				+ id, Level.INFO, null);
		try {
			Servicestation instance = getEntityManager().find(
					Servicestation.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Servicestation entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Servicestation property to query
	 * @param value
	 *            the property value to match
	 * @return List<Servicestation> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Servicestation> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding Servicestation instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Servicestation model where model."
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

	public List<Servicestation> findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List<Servicestation> findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List<Servicestation> findBySpname(Object spname) {
		return findByProperty(SPNAME, spname);
	}

	public List<Servicestation> findBySptel(Object sptel) {
		return findByProperty(SPTEL, sptel);
	}

	/**
	 * Find all Servicestation entities.
	 * 
	 * @return List<Servicestation> all Servicestation entities
	 */
	@SuppressWarnings("unchecked")
	public List<Servicestation> findAll() {
		EntityManagerHelper.log("finding all Servicestation instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Servicestation model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}