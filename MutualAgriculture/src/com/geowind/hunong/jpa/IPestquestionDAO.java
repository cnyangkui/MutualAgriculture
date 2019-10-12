package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for PestquestionDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPestquestionDAO {
	/**
	 * Perform an initial save of a previously unsaved Pestquestion entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPestquestionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestquestion entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Pestquestion entity);

	/**
	 * Delete a persistent Pestquestion entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPestquestionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Pestquestion entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Pestquestion entity);

	/**
	 * Persist a previously saved Pestquestion entity and return it or a copy of
	 * it to the sender. A copy of the Pestquestion entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IPestquestionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestquestion entity to update
	 * @return Pestquestion the persisted Pestquestion entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Pestquestion update(Pestquestion entity);

	public Pestquestion findById(Integer id);

	/**
	 * Find all Pestquestion entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Pestquestion property to query
	 * @param value
	 *            the property value to match
	 * @return List<Pestquestion> found by query
	 */
	public List<Pestquestion> findByProperty(String propertyName, Object value);

	public List<Pestquestion> findByUploadPic(Object uploadPic);

	public List<Pestquestion> findByDescr(Object descr);

	public List<Pestquestion> findByUtime(Object utime);

	public List<Pestquestion> findByAtime(Object atime);

	public List<Pestquestion> findByStatus(Object status);

	/**
	 * Find all Pestquestion entities.
	 * 
	 * @return List<Pestquestion> all Pestquestion entities
	 */
	public List<Pestquestion> findAll();
}