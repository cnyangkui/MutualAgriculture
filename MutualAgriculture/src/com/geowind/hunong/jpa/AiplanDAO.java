package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Aiplan entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Aiplan
 * @author MyEclipse Persistence Tools
 */
public class AiplanDAO implements IAiplanDAO {
	// property constants
	public static final String EVENT = "event";
	public static final String BNAME = "bname";
	public static final String MNUM = "mnum";
	public static final String TOTALWORK = "totalwork";
	public static final String EFFICIENCY = "efficiency";
	public static final String WEATHER = "weather";
	public static final String WEALEVEL = "wealevel";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Aiplan entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * AiplanDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Aiplan entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Aiplan entity) {
		EntityManagerHelper.log("saving Aiplan instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Aiplan entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * AiplanDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Aiplan entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Aiplan entity) {
		EntityManagerHelper.log("deleting Aiplan instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Aiplan.class,
					entity.getAid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Aiplan entity and return it or a copy of it to
	 * the sender. A copy of the Aiplan entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = AiplanDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Aiplan entity to update
	 * @return Aiplan the persisted Aiplan entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Aiplan update(Aiplan entity) {
		EntityManagerHelper.log("updating Aiplan instance", Level.INFO, null);
		try {
			Aiplan result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Aiplan findById(Integer id) {
		EntityManagerHelper.log("finding Aiplan instance with id: " + id,
				Level.INFO, null);
		try {
			Aiplan instance = getEntityManager().find(Aiplan.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Aiplan entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Aiplan property to query
	 * @param value
	 *            the property value to match
	 * @return List<Aiplan> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Aiplan> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Aiplan instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Aiplan model where model."
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

	public List<Aiplan> findByEvent(Object event) {
		return findByProperty(EVENT, event);
	}

	public List<Aiplan> findByBname(Object bname) {
		return findByProperty(BNAME, bname);
	}

	public List<Aiplan> findByMnum(Object mnum) {
		return findByProperty(MNUM, mnum);
	}

	public List<Aiplan> findByTotalwork(Object totalwork) {
		return findByProperty(TOTALWORK, totalwork);
	}

	public List<Aiplan> findByEfficiency(Object efficiency) {
		return findByProperty(EFFICIENCY, efficiency);
	}

	public List<Aiplan> findByWeather(Object weather) {
		return findByProperty(WEATHER, weather);
	}

	public List<Aiplan> findByWealevel(Object wealevel) {
		return findByProperty(WEALEVEL, wealevel);
	}

	/**
	 * Find all Aiplan entities.
	 * 
	 * @return List<Aiplan> all Aiplan entities
	 */
	@SuppressWarnings("unchecked")
	public List<Aiplan> findAll() {
		EntityManagerHelper.log("finding all Aiplan instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Aiplan model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}