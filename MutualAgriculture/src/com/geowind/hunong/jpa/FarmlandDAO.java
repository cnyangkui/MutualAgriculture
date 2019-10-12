package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Farmland entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Farmland
 * @author MyEclipse Persistence Tools
 */
public class FarmlandDAO implements IFarmlandDAO {
	// property constants
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String ADDRESS = "address";
	public static final String AREA = "area";
	public static final String PICTURE = "picture";
	public static final String TRANSTION = "transtion";
	public static final String PRODUCTION = "production";
	public static final String PH = "ph";
	public static final String NPK = "npk";
	public static final String STATE = "state";
	public static final String VALID = "valid";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Farmland entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * FarmlandDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Farmland entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Farmland entity) {
		EntityManagerHelper.log("saving Farmland instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Farmland entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * FarmlandDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Farmland entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Farmland entity) {
		EntityManagerHelper.log("deleting Farmland instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Farmland.class,
					entity.getFarmlandId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Farmland entity and return it or a copy of it
	 * to the sender. A copy of the Farmland entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = FarmlandDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Farmland entity to update
	 * @return Farmland the persisted Farmland entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Farmland update(Farmland entity) {
		EntityManagerHelper.log("updating Farmland instance", Level.INFO, null);
		try {
			Farmland result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Farmland findById(Integer id) {
		EntityManagerHelper.log("finding Farmland instance with id: " + id,
				Level.INFO, null);
		try {
			Farmland instance = getEntityManager().find(Farmland.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Farmland entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Farmland property to query
	 * @param value
	 *            the property value to match
	 * @return List<Farmland> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Farmland> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Farmland instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Farmland model where model."
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

	public List<Farmland> findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List<Farmland> findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List<Farmland> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Farmland> findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List<Farmland> findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List<Farmland> findByTranstion(Object transtion) {
		return findByProperty(TRANSTION, transtion);
	}

	public List<Farmland> findByProduction(Object production) {
		return findByProperty(PRODUCTION, production);
	}

	public List<Farmland> findByPh(Object ph) {
		return findByProperty(PH, ph);
	}

	public List<Farmland> findByNpk(Object npk) {
		return findByProperty(NPK, npk);
	}

	public List<Farmland> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Farmland> findByValid(Object valid) {
		return findByProperty(VALID, valid);
	}

	/**
	 * Find all Farmland entities.
	 * 
	 * @return List<Farmland> all Farmland entities
	 */
	@SuppressWarnings("unchecked")
	public List<Farmland> findAll() {
		EntityManagerHelper.log("finding all Farmland instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Farmland model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}