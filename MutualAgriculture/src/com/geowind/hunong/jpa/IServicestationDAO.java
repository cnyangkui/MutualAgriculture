package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for ServicestationDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IServicestationDAO {
	/**
	 * Perform an initial save of a previously unsaved Servicestation entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IServicestationDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Servicestation entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Servicestation entity);

	/**
	 * Delete a persistent Servicestation entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IServicestationDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Servicestation entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Servicestation entity);

	/**
	 * Persist a previously saved Servicestation entity and return it or a copy
	 * of it to the sender. A copy of the Servicestation entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IServicestationDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Servicestation entity to update
	 * @return Servicestation the persisted Servicestation entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Servicestation update(Servicestation entity);

	public Servicestation findById(Integer id);

	/**
	 * Find all Servicestation entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Servicestation property to query
	 * @param value
	 *            the property value to match
	 * @return List<Servicestation> found by query
	 */
	public List<Servicestation> findByProperty(String propertyName, Object value);

	public List<Servicestation> findByLongitude(Object longitude);

	public List<Servicestation> findByLatitude(Object latitude);

	public List<Servicestation> findBySpname(Object spname);

	public List<Servicestation> findBySptel(Object sptel);

	/**
	 * Find all Servicestation entities.
	 * 
	 * @return List<Servicestation> all Servicestation entities
	 */
	public List<Servicestation> findAll();
}