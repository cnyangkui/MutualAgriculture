package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Interface for MachineownerDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IMachineownerDAO {
	/**
	 * Perform an initial save of a previously unsaved Machineowner entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMachineownerDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Machineowner entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Machineowner entity);

	/**
	 * Delete a persistent Machineowner entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IMachineownerDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Machineowner entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Machineowner entity);

	/**
	 * Persist a previously saved Machineowner entity and return it or a copy of
	 * it to the sender. A copy of the Machineowner entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IMachineownerDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Machineowner entity to update
	 * @return Machineowner the persisted Machineowner entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Machineowner update(Machineowner entity);

	public Machineowner findById(Integer id);

	/**
	 * Find all Machineowner entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Machineowner property to query
	 * @param value
	 *            the property value to match
	 * @return List<Machineowner> found by query
	 */
	public List<Machineowner> findByProperty(String propertyName, Object value);

	public List<Machineowner> findByName(Object name);

	public List<Machineowner> findBySex(Object sex);

	public List<Machineowner> findByPhone(Object phone);

	public List<Machineowner> findByAddress(Object address);

	public List<Machineowner> findByValid(Object valid);

	/**
	 * Find all Machineowner entities.
	 * 
	 * @return List<Machineowner> all Machineowner entities
	 */
	public List<Machineowner> findAll();
}