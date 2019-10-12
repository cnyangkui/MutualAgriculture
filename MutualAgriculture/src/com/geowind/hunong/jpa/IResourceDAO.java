package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;

/**
 * Interface for ResourceDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IResourceDAO {
	/**
	 * Perform an initial save of a previously unsaved Resource entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IResourceDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Resource entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Resource entity);

	/**
	 * Delete a persistent Resource entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IResourceDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Resource entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Resource entity);

	/**
	 * Persist a previously saved Resource entity and return it or a copy of it
	 * to the sender. A copy of the Resource entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IResourceDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Resource entity to update
	 * @return Resource the persisted Resource entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Resource update(Resource entity);

	public Resource findById(Integer id);

	/**
	 * Find all Resource entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Resource property to query
	 * @param value
	 *            the property value to match
	 * @return List<Resource> found by query
	 */
	public List<Resource> findByProperty(String propertyName, Object value);

	public List<Resource> findByType(Object type);

	public List<Resource> findByName(Object name);

	public List<Resource> findByPrice(Object price);

	public List<Resource> findByFunction(Object function);

	/**
	 * Find all Resource entities.
	 * 
	 * @return List<Resource> all Resource entities
	 */
	public List<Resource> findAll();
}