package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Order
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Order
 * @author MyEclipse Persistence Tools
 */
public class OrderDAO implements IOrderDAO {
	// property constants
	public static final String TOTAL_PRICE = "totalPrice";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Order entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OrderDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Order entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Order entity) {
		EntityManagerHelper.log("saving Order instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Order entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * OrderDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Order entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Order entity) {
		EntityManagerHelper.log("deleting Order instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Order.class,
					entity.getOrderId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Order entity and return it or a copy of it to
	 * the sender. A copy of the Order entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = OrderDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Order entity to update
	 * @return Order the persisted Order entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Order update(Order entity) {
		EntityManagerHelper.log("updating Order instance", Level.INFO, null);
		try {
			Order result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Order findById(String id) {
		EntityManagerHelper.log("finding Order instance with id: " + id,
				Level.INFO, null);
		try {
			Order instance = getEntityManager().find(Order.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Order entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Order property to query
	 * @param value
	 *            the property value to match
	 * @return List<Order> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Order> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Order instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Order model where model."
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

	public List<Order> findByTotalPrice(Object totalPrice) {
		return findByProperty(TOTAL_PRICE, totalPrice);
	}

	/**
	 * Find all Order entities.
	 * 
	 * @return List<Order> all Order entities
	 */
	@SuppressWarnings("unchecked")
	public List<Order> findAll() {
		EntityManagerHelper
				.log("finding all Order instances", Level.INFO, null);
		try {
			final String queryString = "select model from Order model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}