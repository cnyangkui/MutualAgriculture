package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;

/**
 * Interface for TraderDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITraderDAO {
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
	 * ITraderDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Trader entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Trader entity);

	/**
	 * Delete a persistent Trader entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITraderDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Trader entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Trader entity);

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
	 * entity = ITraderDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Trader entity to update
	 * @return Trader the persisted Trader entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Trader update(Trader entity);

	public Trader findById(Integer id);

	/**
	 * Find all Trader entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Trader property to query
	 * @param value
	 *            the property value to match
	 * @return List<Trader> found by query
	 */
	public List<Trader> findByProperty(String propertyName, Object value);

	public List<Trader> findByPhone(Object phone);

	public List<Trader> findByName(Object name);

	public List<Trader> findByCredit(Object credit);

	public List<Trader> findByAddress(Object address);

	/**
	 * Find all Trader entities.
	 * 
	 * @return List<Trader> all Trader entities
	 */
	public List<Trader> findAll();
}