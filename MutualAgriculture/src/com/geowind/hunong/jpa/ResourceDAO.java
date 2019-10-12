package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Resource entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Resource
 * @author MyEclipse Persistence Tools
 */
public class ResourceDAO implements IResourceDAO {
	// property constants
	public static final String TYPE = "type";
	public static final String NAME = "name";
	public static final String PRICE = "price";
	public static final String FUNCTION = "function";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Resource entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ResourceDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Resource entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Resource entity) {
		EntityManagerHelper.log("saving Resource instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Resource entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ResourceDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Resource entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Resource entity) {
		EntityManagerHelper.log("deleting Resource instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Resource.class,
					entity.getResourceId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Resource entity and return it or a copy of it
	 * to the sender. A copy of the Resource entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ResourceDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Resource entity to update
	 * @return Resource the persisted Resource entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Resource update(Resource entity) {
		EntityManagerHelper.log("updating Resource instance", Level.INFO, null);
		try {
			Resource result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Resource findById(Integer id) {
		EntityManagerHelper.log("finding Resource instance with id: " + id,
				Level.INFO, null);
		try {
			Resource instance = getEntityManager().find(Resource.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Resource entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Resource property to query
	 * @param value
	 *            the property value to match
	 * @return List<Resource> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Resource> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Resource instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Resource model where model."
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

	public List<Resource> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Resource> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Resource> findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List<Resource> findByFunction(Object function) {
		return findByProperty(FUNCTION, function);
	}

	/**
	 * Find all Resource entities.
	 * 
	 * @return List<Resource> all Resource entities
	 */
	@SuppressWarnings("unchecked")
	public List<Resource> findAll() {
		EntityManagerHelper.log("finding all Resource instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Resource model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}