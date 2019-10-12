package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for AiplanDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IAiplanDAO {
	/**
	 * Perform an initial save of a previously unsaved Aiplan entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAiplanDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Aiplan entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Aiplan entity);

	/**
	 * Delete a persistent Aiplan entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAiplanDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Aiplan entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Aiplan entity);

	/**
	 * Persist a previously saved Aiplan entity and return it or a copy of it to
	 * the sender. A copy of the Aiplan entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IAiplanDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Aiplan entity to update
	 * @return Aiplan the persisted Aiplan entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Aiplan update(Aiplan entity);

	public Aiplan findById(Integer id);

	/**
	 * Find all Aiplan entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Aiplan property to query
	 * @param value
	 *            the property value to match
	 * @return List<Aiplan> found by query
	 */
	public List<Aiplan> findByProperty(String propertyName, Object value);

	public List<Aiplan> findByEvent(Object event);

	public List<Aiplan> findByBname(Object bname);

	public List<Aiplan> findByMnum(Object mnum);

	public List<Aiplan> findByTotalwork(Object totalwork);

	public List<Aiplan> findByEfficiency(Object efficiency);

	public List<Aiplan> findByWeather(Object weather);

	public List<Aiplan> findByWealevel(Object wealevel);

	/**
	 * Find all Aiplan entities.
	 * 
	 * @return List<Aiplan> all Aiplan entities
	 */
	public List<Aiplan> findAll();
}