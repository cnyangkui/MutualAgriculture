package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for OrderitemDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IOrderitemDAO {
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
	 * IOrderitemDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Orderitem entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Orderitem entity);

	/**
	 * Delete a persistent Orderitem entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IOrderitemDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Orderitem entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Orderitem entity);

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
	 * entity = IOrderitemDAO.update(entity);
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
	public Orderitem update(Orderitem entity);

	public Orderitem findById(Integer id);

	/**
	 * Find all Orderitem entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Orderitem property to query
	 * @param value
	 *            the property value to match
	 * @return List<Orderitem> found by query
	 */
	public List<Orderitem> findByProperty(String propertyName, Object value);

	public List<Orderitem> findByCount(Object count);

	public List<Orderitem> findByTotalPrice(Object totalPrice);

	/**
	 * Find all Orderitem entities.
	 * 
	 * @return List<Orderitem> all Orderitem entities
	 */
	public List<Orderitem> findAll();
}