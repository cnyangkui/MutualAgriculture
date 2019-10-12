package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Center entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Center
 * @author MyEclipse Persistence Tools
 */
public class CenterDAO implements ICenterDAO {
	// property constants
	public static final String ADDRESS = "address";
	public static final String LEVEL = "level";
	public static final String NAME = "name";
	public static final String PRINCIPAL = "principal";
	public static final String VALID = "valid";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Center entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * CenterDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Center entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Center entity) {
		EntityManagerHelper.log("saving Center instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Center entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * CenterDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Center entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Center entity) {
		EntityManagerHelper.log("deleting Center instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Center.class,
					entity.getCenterId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Center entity and return it or a copy of it to
	 * the sender. A copy of the Center entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = CenterDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Center entity to update
	 * @return Center the persisted Center entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Center update(Center entity) {
		EntityManagerHelper.log("updating Center instance", Level.INFO, null);
		try {
			Center result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Center findById(Integer id) {
		EntityManagerHelper.log("finding Center instance with id: " + id,
				Level.INFO, null);
		try {
			Center instance = getEntityManager().find(Center.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Center entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Center property to query
	 * @param value
	 *            the property value to match
	 * @return List<Center> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Center> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Center instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Center model where model."
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

	public List<Center> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Center> findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List<Center> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Center> findByPrincipal(Object principal) {
		return findByProperty(PRINCIPAL, principal);
	}

	public List<Center> findByValid(Object valid) {
		return findByProperty(VALID, valid);
	}

	/**
	 * Find all Center entities.
	 * 
	 * @return List<Center> all Center entities
	 */
	@SuppressWarnings("unchecked")
	public List<Center> findAll() {
		EntityManagerHelper.log("finding all Center instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Center model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}