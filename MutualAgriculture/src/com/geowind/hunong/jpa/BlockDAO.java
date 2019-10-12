package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Block
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Block
 * @author MyEclipse Persistence Tools
 */
public class BlockDAO implements IBlockDAO {
	// property constants
	public static final String BNAME = "bname";
	public static final String AREA = "area";
	public static final String ADDRESS = "address";
	public static final String VALID = "valid";
	public static final String LONGITUDE = "longitude";
	public static final String LATITUDE = "latitude";
	public static final String PICTURE = "picture";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

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
	 * BlockDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Block entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Block entity) {
		EntityManagerHelper.log("saving Block instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Block entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * BlockDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Block entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Block entity) {
		EntityManagerHelper.log("deleting Block instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Block.class,
					entity.getBid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 * entity = BlockDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Block entity to update
	 * @return Block the persisted Block entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Block update(Block entity) {
		EntityManagerHelper.log("updating Block instance", Level.INFO, null);
		try {
			Block result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Block findById(Integer id) {
		EntityManagerHelper.log("finding Block instance with id: " + id,
				Level.INFO, null);
		try {
			Block instance = getEntityManager().find(Block.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Block entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Block property to query
	 * @param value
	 *            the property value to match
	 * @return List<Block> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Block> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Block instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Block model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<Block> findByBname(Object bname) {
		return findByProperty(BNAME, bname);
	}

	public List<Block> findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List<Block> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Block> findByValid(Object valid) {
		return findByProperty(VALID, valid);
	}

	public List<Block> findByLongitude(Object longitude) {
		return findByProperty(LONGITUDE, longitude);
	}

	public List<Block> findByLatitude(Object latitude) {
		return findByProperty(LATITUDE, latitude);
	}

	public List<Block> findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	/**
	 * Find all Block entities.
	 * 
	 * @return List<Block> all Block entities
	 */
	@SuppressWarnings("unchecked")
	public List<Block> findAll() {
		EntityManagerHelper
				.log("finding all Block instances", Level.INFO, null);
		try {
			final String queryString = "select model from Block model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}