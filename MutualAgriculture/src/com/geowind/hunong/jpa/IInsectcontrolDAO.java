package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for InsectcontrolDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IInsectcontrolDAO {
	/**
	 * Perform an initial save of a previously unsaved Insectcontrol entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IInsectcontrolDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Insectcontrol entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Insectcontrol entity);

	/**
	 * Delete a persistent Insectcontrol entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IInsectcontrolDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Insectcontrol entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Insectcontrol entity);

	/**
	 * Persist a previously saved Insectcontrol entity and return it or a copy
	 * of it to the sender. A copy of the Insectcontrol entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IInsectcontrolDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Insectcontrol entity to update
	 * @return Insectcontrol the persisted Insectcontrol entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Insectcontrol update(Insectcontrol entity);

	public Insectcontrol findById(Integer id);

	/**
	 * Find all Insectcontrol entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Insectcontrol property to query
	 * @param value
	 *            the property value to match
	 * @return List<Insectcontrol> found by query
	 */
	public List<Insectcontrol> findByProperty(String propertyName, Object value);

	public List<Insectcontrol> findByDescr(Object descr);

	public List<Insectcontrol> findByUploadImage(Object uploadImage);

	public List<Insectcontrol> findByUploadtime(Object uploadtime);

	public List<Insectcontrol> findByInsectImage(Object insectImage);

	public List<Insectcontrol> findByInfo(Object info);

	public List<Insectcontrol> findByHarm(Object harm);

	public List<Insectcontrol> findByCounterplan(Object counterplan);

	public List<Insectcontrol> findBySolvetime(Object solvetime);

	public List<Insectcontrol> findByStatus(Object status);

	/**
	 * Find all Insectcontrol entities.
	 * 
	 * @return List<Insectcontrol> all Insectcontrol entities
	 */
	public List<Insectcontrol> findAll();
}