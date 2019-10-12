package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Zone
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Zone
 * @author MyEclipse Persistence Tools
 */
public class ZoneDAO implements IZoneDAO {
	// property constants
	public static final String ZONENAME = "zonename";
	public static final String AREA = "area";
	public static final String TYPE = "type";
	public static final String ADDRESS = "address";
	public static final String VALID = "valid";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Zone entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ZoneDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Zone entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Zone entity) {
		EntityManagerHelper.log("saving Zone instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Zone entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ZoneDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Zone entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Zone entity) {
		EntityManagerHelper.log("deleting Zone instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Zone.class,
					entity.getZoneId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Zone entity and return it or a copy of it to
	 * the sender. A copy of the Zone entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ZoneDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Zone entity to update
	 * @return Zone the persisted Zone entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Zone update(Zone entity) {
		EntityManagerHelper.log("updating Zone instance", Level.INFO, null);
		try {
			Zone result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Zone findById(Integer id) {
		EntityManagerHelper.log("finding Zone instance with id: " + id,
				Level.INFO, null);
		try {
			Zone instance = getEntityManager().find(Zone.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Zone entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Zone property to query
	 * @param value
	 *            the property value to match
	 * @return List<Zone> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Zone> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Zone instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Zone model where model."
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

	public List<Zone> findByZonename(Object zonename) {
		return findByProperty(ZONENAME, zonename);
	}

	public List<Zone> findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List<Zone> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Zone> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Zone> findByValid(Object valid) {
		return findByProperty(VALID, valid);
	}

	/**
	 * Find all Zone entities.
	 * 
	 * @return List<Zone> all Zone entities
	 */
	@SuppressWarnings("unchecked")
	public List<Zone> findAll() {
		EntityManagerHelper.log("finding all Zone instances", Level.INFO, null);
		try {
			final String queryString = "select model from Zone model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}