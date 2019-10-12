package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Trader entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Trader
 * @author MyEclipse Persistence Tools
 */
public class TraderDAO implements ITraderDAO {
	// property constants
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String CREDIT = "credit";
	public static final String ADDRESS = "address";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Trader entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TraderDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Trader entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Trader entity) {
		EntityManagerHelper.log("saving Trader instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Trader entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TraderDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Trader entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Trader entity) {
		EntityManagerHelper.log("deleting Trader instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Trader.class,
					entity.getTraderId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Trader entity and return it or a copy of it to
	 * the sender. A copy of the Trader entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = TraderDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Trader entity to update
	 * @return Trader the persisted Trader entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Trader update(Trader entity) {
		EntityManagerHelper.log("updating Trader instance", Level.INFO, null);
		try {
			Trader result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Trader findById(Integer id) {
		EntityManagerHelper.log("finding Trader instance with id: " + id,
				Level.INFO, null);
		try {
			Trader instance = getEntityManager().find(Trader.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Trader entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Trader property to query
	 * @param value
	 *            the property value to match
	 * @return List<Trader> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Trader> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Trader instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Trader model where model."
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

	public List<Trader> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Trader> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Trader> findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List<Trader> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	/**
	 * Find all Trader entities.
	 * 
	 * @return List<Trader> all Trader entities
	 */
	@SuppressWarnings("unchecked")
	public List<Trader> findAll() {
		EntityManagerHelper.log("finding all Trader instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Trader model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}