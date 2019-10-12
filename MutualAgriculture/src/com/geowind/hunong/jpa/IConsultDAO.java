package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for ConsultDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IConsultDAO {
	/**
	 * Perform an initial save of a previously unsaved Consult entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IConsultDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Consult entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Consult entity);

	/**
	 * Delete a persistent Consult entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IConsultDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Consult entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Consult entity);

	/**
	 * Persist a previously saved Consult entity and return it or a copy of it
	 * to the sender. A copy of the Consult entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IConsultDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Consult entity to update
	 * @return Consult the persisted Consult entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Consult update(Consult entity);

	public Consult findById(Integer id);

	/**
	 * Find all Consult entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Consult property to query
	 * @param value
	 *            the property value to match
	 * @return List<Consult> found by query
	 */
	public List<Consult> findByProperty(String propertyName, Object value);

	public List<Consult> findByCcontent(Object ccontent);

	public List<Consult> findByCtime(Object ctime);

	public List<Consult> findByAcontent(Object acontent);

	public List<Consult> findByKeywords(Object keywords);

	public List<Consult> findByAtime(Object atime);

	public List<Consult> findByStatus(Object status);

	/**
	 * Find all Consult entities.
	 * 
	 * @return List<Consult> all Consult entities
	 */
	public List<Consult> findAll();
}