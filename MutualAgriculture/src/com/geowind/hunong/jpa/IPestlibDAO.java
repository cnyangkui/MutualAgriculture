package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;

/**
 * Interface for PestlibDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPestlibDAO {
	/**
	 * Perform an initial save of a previously unsaved Pestlib entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPestlibDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestlib entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Pestlib entity);

	/**
	 * Delete a persistent Pestlib entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPestlibDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Pestlib entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Pestlib entity);

	/**
	 * Persist a previously saved Pestlib entity and return it or a copy of it
	 * to the sender. A copy of the Pestlib entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IPestlibDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestlib entity to update
	 * @return Pestlib the persisted Pestlib entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Pestlib update(Pestlib entity);

	public Pestlib findById(Integer id);

	/**
	 * Find all Pestlib entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Pestlib property to query
	 * @param value
	 *            the property value to match
	 * @return List<Pestlib> found by query
	 */
	public List<Pestlib> findByProperty(String propertyName, Object value);

	public List<Pestlib> findByPestname(Object pestname);

	public List<Pestlib> findByBranch(Object branch);

	public List<Pestlib> findByInfo(Object info);

	public List<Pestlib> findByMethod(Object method);

	public List<Pestlib> findByPic(Object pic);

	/**
	 * Find all Pestlib entities.
	 * 
	 * @return List<Pestlib> all Pestlib entities
	 */
	public List<Pestlib> findAll();
}