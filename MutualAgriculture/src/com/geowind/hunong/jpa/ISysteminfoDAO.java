package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for SysteminfoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISysteminfoDAO {
	/**
	 * Perform an initial save of a previously unsaved Systeminfo entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISysteminfoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Systeminfo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Systeminfo entity);

	/**
	 * Delete a persistent Systeminfo entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ISysteminfoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Systeminfo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Systeminfo entity);

	/**
	 * Persist a previously saved Systeminfo entity and return it or a copy of
	 * it to the sender. A copy of the Systeminfo entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ISysteminfoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Systeminfo entity to update
	 * @return Systeminfo the persisted Systeminfo entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Systeminfo update(Systeminfo entity);

	public Systeminfo findById(Integer id);

	/**
	 * Find all Systeminfo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Systeminfo property to query
	 * @param value
	 *            the property value to match
	 * @return List<Systeminfo> found by query
	 */
	public List<Systeminfo> findByProperty(String propertyName, Object value);

	public List<Systeminfo> findByTitle(Object title);

	public List<Systeminfo> findByContent(Object content);

	/**
	 * Find all Systeminfo entities.
	 * 
	 * @return List<Systeminfo> all Systeminfo entities
	 */
	public List<Systeminfo> findAll();
}