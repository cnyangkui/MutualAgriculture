package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Interface for OrderDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IOrderDAO {
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
	 * IOrderDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Order entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Order entity);

	/**
	 * Delete a persistent Order entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOrderDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Order entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Order entity);

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
	 * entity = IOrderDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Order entity to update
	 * @return Order the persisted Order entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Order update(Order entity);

	public Order findById(String id);

	/**
	 * Find all Order entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Order property to query
	 * @param value
	 *            the property value to match
	 * @return List<Order> found by query
	 */
	public List<Order> findByProperty(String propertyName, Object value);

	public List<Order> findByTotalPrice(Object totalPrice);

	/**
	 * Find all Order entities.
	 * 
	 * @return List<Order> all Order entities
	 */
	public List<Order> findAll();
}