package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;

/**
 * Interface for BlockDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IBlockDAO {
	/**
	 * Perform an initial save of a previously unsaved Block entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IBlockDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Block entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Block entity);

	/**
	 * Delete a persistent Block entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IBlockDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Block entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Block entity);

	/**
	 * Persist a previously saved Block entity and return it or a copy of it to
	 * the sender. A copy of the Block entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IBlockDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Block entity to update
	 * @return Block the persisted Block entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Block update(Block entity);

	public Block findById(Integer id);

	/**
	 * Find all Block entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Block property to query
	 * @param value
	 *            the property value to match
	 * @return List<Block> found by query
	 */
	public List<Block> findByProperty(String propertyName, Object value);

	public List<Block> findByBname(Object bname);

	public List<Block> findByArea(Object area);

	public List<Block> findByAddress(Object address);

	public List<Block> findByValid(Object valid);

	public List<Block> findByLongitude(Object longitude);

	public List<Block> findByLatitude(Object latitude);

	public List<Block> findByPicture(Object picture);

	/**
	 * Find all Block entities.
	 * 
	 * @return List<Block> all Block entities
	 */
	public List<Block> findAll();
}