package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for AdminDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IAdminDAO {
	/**
	 * Perform an initial save of a previously unsaved Admin entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAdminDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Admin entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Admin entity);

	/**
	 * Delete a persistent Admin entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IAdminDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Admin entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Admin entity);

	/**
	 * Persist a previously saved Admin entity and return it or a copy of it to
	 * the sender. A copy of the Admin entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IAdminDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Admin entity to update
	 * @return Admin the persisted Admin entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Admin update(Admin entity);

	public Admin findById(Integer id);

	/**
	 * Find all Admin entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Admin property to query
	 * @param value
	 *            the property value to match
	 * @return List<Admin> found by query
	 */
	public List<Admin> findByProperty(String propertyName, Object value);

	public List<Admin> findByAname(Object aname);

	public List<Admin> findByRealname(Object realname);

	public List<Admin> findByPwd(Object pwd);

	public List<Admin> findByStatus(Object status);

	/**
	 * Find all Admin entities.
	 * 
	 * @return List<Admin> all Admin entities
	 */
	public List<Admin> findAll();
}