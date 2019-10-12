package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for PlanstandardDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPlanstandardDAO {
	/**
	 * Perform an initial save of a previously unsaved Planstandard entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPlanstandardDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Planstandard entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Planstandard entity);

	/**
	 * Delete a persistent Planstandard entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPlanstandardDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Planstandard entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Planstandard entity);

	/**
	 * Persist a previously saved Planstandard entity and return it or a copy of
	 * it to the sender. A copy of the Planstandard entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IPlanstandardDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Planstandard entity to update
	 * @return Planstandard the persisted Planstandard entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Planstandard update(Planstandard entity);

	public Planstandard findById(Integer id);

	/**
	 * Find all Planstandard entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Planstandard property to query
	 * @param value
	 *            the property value to match
	 * @return List<Planstandard> found by query
	 */
	public List<Planstandard> findByProperty(String propertyName, Object value);

	public List<Planstandard> findByEvent(Object event);

	public List<Planstandard> findByBegin(Object begin);

	public List<Planstandard> findByEnd(Object end);

	public List<Planstandard> findByMaxdays(Object maxdays);

	public List<Planstandard> findByTotalwork(Object totalwork);

	public List<Planstandard> findByEfficiency(Object efficiency);

	/**
	 * Find all Planstandard entities.
	 * 
	 * @return List<Planstandard> all Planstandard entities
	 */
	public List<Planstandard> findAll();
}