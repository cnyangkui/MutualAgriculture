package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Systeminfo entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Systeminfo
 * @author MyEclipse Persistence Tools
 */
public class SysteminfoDAO implements ISysteminfoDAO {
	// property constants
	public static final String TITLE = "title";
	public static final String CONTENT = "content";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Systeminfo entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * SysteminfoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Systeminfo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Systeminfo entity) {
		EntityManagerHelper.log("saving Systeminfo instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Systeminfo entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * SysteminfoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Systeminfo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Systeminfo entity) {
		EntityManagerHelper.log("deleting Systeminfo instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Systeminfo.class,
					entity.getSid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Systeminfo entity and return it or a copy of
	 * it to the sender. A copy of the Systeminfo entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = SysteminfoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Systeminfo entity to update
	 * @return Systeminfo the persisted Systeminfo entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Systeminfo update(Systeminfo entity) {
		EntityManagerHelper.log("updating Systeminfo instance", Level.INFO,
				null);
		try {
			Systeminfo result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Systeminfo findById(Integer id) {
		EntityManagerHelper.log("finding Systeminfo instance with id: " + id,
				Level.INFO, null);
		try {
			Systeminfo instance = getEntityManager().find(Systeminfo.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Systeminfo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Systeminfo property to query
	 * @param value
	 *            the property value to match
	 * @return List<Systeminfo> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Systeminfo> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding Systeminfo instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Systeminfo model where model."
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

	public List<Systeminfo> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Systeminfo> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	/**
	 * Find all Systeminfo entities.
	 * 
	 * @return List<Systeminfo> all Systeminfo entities
	 */
	@SuppressWarnings("unchecked")
	public List<Systeminfo> findAll() {
		EntityManagerHelper.log("finding all Systeminfo instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Systeminfo model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}