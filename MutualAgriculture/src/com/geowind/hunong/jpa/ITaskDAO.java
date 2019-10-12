package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;

/**
 * Interface for TaskDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ITaskDAO {
	/**
	 * Perform an initial save of a previously unsaved Task entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITaskDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Task entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Task entity);

	/**
	 * Delete a persistent Task entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ITaskDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Task entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Task entity);

	/**
	 * Persist a previously saved Task entity and return it or a copy of it to
	 * the sender. A copy of the Task entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ITaskDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Task entity to update
	 * @return Task the persisted Task entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Task update(Task entity);

	public Task findById(Integer id);

	/**
	 * Find all Task entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Task property to query
	 * @param value
	 *            the property value to match
	 * @return List<Task> found by query
	 */
	public List<Task> findByProperty(String propertyName, Object value);

	public List<Task> findByWorkload(Object workload);

	public List<Task> findByType(Object type);

	public List<Task> findByFinished(Object finished);

	public List<Task> findByDescr(Object descr);

	/**
	 * Find all Task entities.
	 * 
	 * @return List<Task> all Task entities
	 */
	public List<Task> findAll();
}