package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;

/**
 * Interface for CenterDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICenterDAO {
	/**
	 * Perform an initial save of a previously unsaved Center entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ICenterDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Center entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Center entity);

	/**
	 * Delete a persistent Center entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ICenterDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Center entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Center entity);

	/**
	 * Persist a previously saved Center entity and return it or a copy of it to
	 * the sender. A copy of the Center entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ICenterDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Center entity to update
	 * @return Center the persisted Center entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Center update(Center entity);

	public Center findById(Integer id);

	/**
	 * Find all Center entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Center property to query
	 * @param value
	 *            the property value to match
	 * @return List<Center> found by query
	 */
	public List<Center> findByProperty(String propertyName, Object value);

	public List<Center> findByAddress(Object address);

	public List<Center> findByLevel(Object level);

	public List<Center> findByName(Object name);

	public List<Center> findByPrincipal(Object principal);

	public List<Center> findByValid(Object valid);

	/**
	 * Find all Center entities.
	 * 
	 * @return List<Center> all Center entities
	 */
	public List<Center> findAll();
}