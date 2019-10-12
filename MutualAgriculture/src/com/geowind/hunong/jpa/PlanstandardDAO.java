package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Planstandard entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Planstandard
 * @author MyEclipse Persistence Tools
 */
public class PlanstandardDAO implements IPlanstandardDAO {
	// property constants
	public static final String EVENT = "event";
	public static final String BEGIN = "begin";
	public static final String END = "end";
	public static final String MAXDAYS = "maxdays";
	public static final String TOTALWORK = "totalwork";
	public static final String EFFICIENCY = "efficiency";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Planstandard entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PlanstandardDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Planstandard entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Planstandard entity) {
		EntityManagerHelper.log("saving Planstandard instance", Level.INFO,
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
	 * Delete a persistent Planstandard entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PlanstandardDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Planstandard entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Planstandard entity) {
		EntityManagerHelper.log("deleting Planstandard instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Planstandard.class,
					entity.getPid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Planstandard entity and return it or a copy of
	 * it to the sender. A copy of the Planstandard entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = PlanstandardDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Planstandard entity to update
	 * @return Planstandard the persisted Planstandard entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Planstandard update(Planstandard entity) {
		EntityManagerHelper.log("updating Planstandard instance", Level.INFO,
				null);
		try {
			Planstandard result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Planstandard findById(Integer id) {
		EntityManagerHelper.log("finding Planstandard instance with id: " + id,
				Level.INFO, null);
		try {
			Planstandard instance = getEntityManager().find(Planstandard.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Planstandard entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Planstandard property to query
	 * @param value
	 *            the property value to match
	 * @return List<Planstandard> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Planstandard> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding Planstandard instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Planstandard model where model."
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

	public List<Planstandard> findByEvent(Object event) {
		return findByProperty(EVENT, event);
	}

	public List<Planstandard> findByBegin(Object begin) {
		return findByProperty(BEGIN, begin);
	}

	public List<Planstandard> findByEnd(Object end) {
		return findByProperty(END, end);
	}

	public List<Planstandard> findByMaxdays(Object maxdays) {
		return findByProperty(MAXDAYS, maxdays);
	}

	public List<Planstandard> findByTotalwork(Object totalwork) {
		return findByProperty(TOTALWORK, totalwork);
	}

	public List<Planstandard> findByEfficiency(Object efficiency) {
		return findByProperty(EFFICIENCY, efficiency);
	}

	/**
	 * Find all Planstandard entities.
	 * 
	 * @return List<Planstandard> all Planstandard entities
	 */
	@SuppressWarnings("unchecked")
	public List<Planstandard> findAll() {
		EntityManagerHelper.log("finding all Planstandard instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Planstandard model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}