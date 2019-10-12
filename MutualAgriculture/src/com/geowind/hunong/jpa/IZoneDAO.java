package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;

/**
 * Interface for ZoneDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IZoneDAO {
	/**
	 * Perform an initial save of a previously unsaved Zone entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IZoneDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Zone entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Zone entity);

	/**
	 * Delete a persistent Zone entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IZoneDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Zone entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Zone entity);

	/**
	 * Persist a previously saved Zone entity and return it or a copy of it to
	 * the sender. A copy of the Zone entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IZoneDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Zone entity to update
	 * @return Zone the persisted Zone entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Zone update(Zone entity);

	public Zone findById(Integer id);

	/**
	 * Find all Zone entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Zone property to query
	 * @param value
	 *            the property value to match
	 * @return List<Zone> found by query
	 */
	public List<Zone> findByProperty(String propertyName, Object value);

	public List<Zone> findByZonename(Object zonename);

	public List<Zone> findByArea(Object area);

	public List<Zone> findByType(Object type);

	public List<Zone> findByAddress(Object address);

	public List<Zone> findByValid(Object valid);

	/**
	 * Find all Zone entities.
	 * 
	 * @return List<Zone> all Zone entities
	 */
	public List<Zone> findAll();
}