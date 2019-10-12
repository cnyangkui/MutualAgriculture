package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Admin
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Admin
 * @author MyEclipse Persistence Tools
 */
public class AdminDAO implements IAdminDAO {
	// property constants
	public static final String ANAME = "aname";
	public static final String REALNAME = "realname";
	public static final String PWD = "pwd";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

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
	 * AdminDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Admin entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Admin entity) {
		EntityManagerHelper.log("saving Admin instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Admin entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * AdminDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Admin entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Admin entity) {
		EntityManagerHelper.log("deleting Admin instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Admin.class,
					entity.getAid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 * entity = AdminDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Admin entity to update
	 * @return Admin the persisted Admin entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Admin update(Admin entity) {
		EntityManagerHelper.log("updating Admin instance", Level.INFO, null);
		try {
			Admin result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Admin findById(Integer id) {
		EntityManagerHelper.log("finding Admin instance with id: " + id,
				Level.INFO, null);
		try {
			Admin instance = getEntityManager().find(Admin.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Admin entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Admin property to query
	 * @param value
	 *            the property value to match
	 * @return List<Admin> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Admin> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Admin instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Admin model where model."
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

	public List<Admin> findByAname(Object aname) {
		return findByProperty(ANAME, aname);
	}

	public List<Admin> findByRealname(Object realname) {
		return findByProperty(REALNAME, realname);
	}

	public List<Admin> findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	public List<Admin> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/**
	 * Find all Admin entities.
	 * 
	 * @return List<Admin> all Admin entities
	 */
	@SuppressWarnings("unchecked")
	public List<Admin> findAll() {
		EntityManagerHelper
				.log("finding all Admin instances", Level.INFO, null);
		try {
			final String queryString = "select model from Admin model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}