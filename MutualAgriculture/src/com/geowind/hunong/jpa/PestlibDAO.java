package com.geowind.hunong.jpa;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pestlib entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Pestlib
 * @author MyEclipse Persistence Tools
 */
public class PestlibDAO implements IPestlibDAO {
	// property constants
	public static final String PESTNAME = "pestname";
	public static final String BRANCH = "branch";
	public static final String INFO = "info";
	public static final String METHOD = "method";
	public static final String PIC = "pic";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Pestlib entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PestlibDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestlib entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Pestlib entity) {
		EntityManagerHelper.log("saving Pestlib instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Pestlib entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PestlibDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Pestlib entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Pestlib entity) {
		EntityManagerHelper.log("deleting Pestlib instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Pestlib.class,
					entity.getPestId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Pestlib entity and return it or a copy of it
	 * to the sender. A copy of the Pestlib entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = PestlibDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestlib entity to update
	 * @return Pestlib the persisted Pestlib entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Pestlib update(Pestlib entity) {
		EntityManagerHelper.log("updating Pestlib instance", Level.INFO, null);
		try {
			Pestlib result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Pestlib findById(Integer id) {
		EntityManagerHelper.log("finding Pestlib instance with id: " + id,
				Level.INFO, null);
		try {
			Pestlib instance = getEntityManager().find(Pestlib.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Pestlib entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Pestlib property to query
	 * @param value
	 *            the property value to match
	 * @return List<Pestlib> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Pestlib> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Pestlib instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Pestlib model where model."
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

	public List<Pestlib> findByPestname(Object pestname) {
		return findByProperty(PESTNAME, pestname);
	}

	public List<Pestlib> findByBranch(Object branch) {
		return findByProperty(BRANCH, branch);
	}

	public List<Pestlib> findByInfo(Object info) {
		return findByProperty(INFO, info);
	}

	public List<Pestlib> findByMethod(Object method) {
		return findByProperty(METHOD, method);
	}

	public List<Pestlib> findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	/**
	 * Find all Pestlib entities.
	 * 
	 * @return List<Pestlib> all Pestlib entities
	 */
	@SuppressWarnings("unchecked")
	public List<Pestlib> findAll() {
		EntityManagerHelper.log("finding all Pestlib instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Pestlib model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}