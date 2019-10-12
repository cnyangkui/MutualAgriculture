package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Interface for MachineDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMachineDAO {
	/**
	 * Perform an initial save of a previously unsaved Machine entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMachineDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Machine entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Machine entity);

	/**
	 * Delete a persistent Machine entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMachineDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Machine entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Machine entity);

	/**
	 * Persist a previously saved Machine entity and return it or a copy of it
	 * to the sender. A copy of the Machine entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IMachineDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Machine entity to update
	 * @return Machine the persisted Machine entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Machine update(Machine entity);

	public Machine findById(Integer id);

	/**
	 * Find all Machine entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Machine property to query
	 * @param value
	 *            the property value to match
	 * @return List<Machine> found by query
	 */
	public List<Machine> findByProperty(String propertyName, Object value);

	public List<Machine> findByPlate(Object plate);

	public List<Machine> findByType(Object type);

	public List<Machine> findByBrand(Object brand);

	public List<Machine> findByHorsepower(Object horsepower);

	public List<Machine> findByEfficiency(Object efficiency);

	public List<Machine> findByPicture(Object picture);

	public List<Machine> findByState(Object state);

	public List<Machine> findByWorkstate(Object workstate);

	public List<Machine> findByValid(Object valid);

	/**
	 * Find all Machine entities.
	 * 
	 * @return List<Machine> all Machine entities
	 */
	public List<Machine> findAll();
}