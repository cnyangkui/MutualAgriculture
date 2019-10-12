package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for PestzoneDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPestzoneDAO {
	/**
	 * Perform an initial save of a previously unsaved Pestzone entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPestzoneDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestzone entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Pestzone entity);

	/**
	 * Delete a persistent Pestzone entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPestzoneDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Pestzone entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Pestzone entity);

	/**
	 * Persist a previously saved Pestzone entity and return it or a copy of it
	 * to the sender. A copy of the Pestzone entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IPestzoneDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestzone entity to update
	 * @return Pestzone the persisted Pestzone entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Pestzone update(Pestzone entity);

	public Pestzone findById(Integer id);

	/**
	 * Find all Pestzone entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Pestzone property to query
	 * @param value
	 *            the property value to match
	 * @return List<Pestzone> found by query
	 */
	public List<Pestzone> findByProperty(String propertyName, Object value);

	public List<Pestzone> findByDegree(Object degree);

	public List<Pestzone> findByPtype(Object ptype);

	public List<Pestzone> findByItype(Object itype);

	public List<Pestzone> findByTime(Object time);

	public List<Pestzone> findByStatus(Object status);

	/**
	 * Find all Pestzone entities.
	 * 
	 * @return List<Pestzone> all Pestzone entities
	 */
	public List<Pestzone> findAll();
}