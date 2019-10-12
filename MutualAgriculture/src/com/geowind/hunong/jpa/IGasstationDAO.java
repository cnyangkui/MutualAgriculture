package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for GasstationDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IGasstationDAO {
	/**
	 * Perform an initial save of a previously unsaved Gasstation entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IGasstationDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Gasstation entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Gasstation entity);

	/**
	 * Delete a persistent Gasstation entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IGasstationDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Gasstation entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Gasstation entity);

	/**
	 * Persist a previously saved Gasstation entity and return it or a copy of
	 * it to the sender. A copy of the Gasstation entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IGasstationDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Gasstation entity to update
	 * @return Gasstation the persisted Gasstation entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Gasstation update(Gasstation entity);

	public Gasstation findById(Integer id);

	/**
	 * Find all Gasstation entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Gasstation property to query
	 * @param value
	 *            the property value to match
	 * @return List<Gasstation> found by query
	 */
	public List<Gasstation> findByProperty(String propertyName, Object value);

	public List<Gasstation> findByLongitude(Object longitude);

	public List<Gasstation> findByLatitude(Object latitude);

	/**
	 * Find all Gasstation entities.
	 * 
	 * @return List<Gasstation> all Gasstation entities
	 */
	public List<Gasstation> findAll();
}