package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for FarmlandDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IFarmlandDAO {
	/**
	 * Perform an initial save of a previously unsaved Farmland entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IFarmlandDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Farmland entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Farmland entity);

	/**
	 * Delete a persistent Farmland entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IFarmlandDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Farmland entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Farmland entity);

	/**
	 * Persist a previously saved Farmland entity and return it or a copy of it
	 * to the sender. A copy of the Farmland entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IFarmlandDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Farmland entity to update
	 * @return Farmland the persisted Farmland entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Farmland update(Farmland entity);

	public Farmland findById(Integer id);

	/**
	 * Find all Farmland entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Farmland property to query
	 * @param value
	 *            the property value to match
	 * @return List<Farmland> found by query
	 */
	public List<Farmland> findByProperty(String propertyName, Object value);

	public List<Farmland> findByLongitude(Object longitude);

	public List<Farmland> findByLatitude(Object latitude);

	public List<Farmland> findByAddress(Object address);

	public List<Farmland> findByArea(Object area);

	public List<Farmland> findByPicture(Object picture);

	public List<Farmland> findByTranstion(Object transtion);

	public List<Farmland> findByProduction(Object production);

	public List<Farmland> findByPh(Object ph);

	public List<Farmland> findByNpk(Object npk);

	public List<Farmland> findByState(Object state);

	public List<Farmland> findByValid(Object valid);

	/**
	 * Find all Farmland entities.
	 * 
	 * @return List<Farmland> all Farmland entities
	 */
	public List<Farmland> findAll();
}