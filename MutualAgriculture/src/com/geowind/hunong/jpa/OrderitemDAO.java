package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderitem entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Orderitem
 * @author MyEclipse Persistence Tools
 */
public class OrderitemDAO implements IOrderitemDAO {
	// property constants
	public static final String COUNT = "count";
	public static final String TOTAL_PRICE = "totalPrice";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Orderitem entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OrderitemDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Orderitem entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Orderitem entity) {
		EntityManagerHelper.log("saving Orderitem instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Orderitem entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OrderitemDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Orderitem entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Orderitem entity) {
		EntityManagerHelper
				.log("deleting Orderitem instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Orderitem.class,
					entity.getItemId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Orderitem entity and return it or a copy of it
	 * to the sender. A copy of the Orderitem entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = OrderitemDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Orderitem entity to update
	 * @return Orderitem the persisted Orderitem entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Orderitem update(Orderitem entity) {
		EntityManagerHelper
				.log("updating Orderitem instance", Level.INFO, null);
		try {
			Orderitem result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Orderitem findById(Integer id) {
		EntityManagerHelper.log("finding Orderitem instance with id: " + id,
				Level.INFO, null);
		try {
			Orderitem instance = getEntityManager().find(Orderitem.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Orderitem entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Orderitem property to query
	 * @param value
	 *            the property value to match
	 * @return List<Orderitem> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Orderitem> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding Orderitem instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Orderitem model where model."
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

	public List<Orderitem> findByCount(Object count) {
		return findByProperty(COUNT, count);
	}

	public List<Orderitem> findByTotalPrice(Object totalPrice) {
		return findByProperty(TOTAL_PRICE, totalPrice);
	}

	/**
	 * Find all Orderitem entities.
	 * 
	 * @return List<Orderitem> all Orderitem entities
	 */
	@SuppressWarnings("unchecked")
	public List<Orderitem> findAll() {
		EntityManagerHelper.log("finding all Orderitem instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Orderitem model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}