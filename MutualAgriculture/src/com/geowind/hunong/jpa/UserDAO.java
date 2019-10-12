package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.User
 * @author MyEclipse Persistence Tools
 */
public class UserDAO implements IUserDAO {
	// property constants
	public static final String PASSWORD = "password";
	public static final String REALNAME = "realname";
	public static final String SEX = "sex";
	public static final String PHONE = "phone";
	public static final String TYPE = "type";
	public static final String PICTURE = "picture";
	public static final String ADDRESS = "address";
	public static final String CREDIT = "credit";
	public static final String VALID = "valid";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved User entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * UserDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            User entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(User entity) {
		EntityManagerHelper.log("saving User instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent User entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * UserDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            User entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(User entity) {
		EntityManagerHelper.log("deleting User instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(User.class,
					entity.getUsername());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved User entity and return it or a copy of it to
	 * the sender. A copy of the User entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = UserDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            User entity to update
	 * @return User the persisted User entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public User update(User entity) {
		EntityManagerHelper.log("updating User instance", Level.INFO, null);
		try {
			User result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public User findById(String id) {
		EntityManagerHelper.log("finding User instance with id: " + id,
				Level.INFO, null);
		try {
			User instance = getEntityManager().find(User.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all User entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the User property to query
	 * @param value
	 *            the property value to match
	 * @return List<User> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<User> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding User instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from User model where model."
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

	public List<User> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<User> findByRealname(Object realname) {
		return findByProperty(REALNAME, realname);
	}

	public List<User> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<User> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<User> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<User> findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List<User> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<User> findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List<User> findByValid(Object valid) {
		return findByProperty(VALID, valid);
	}

	public List<User> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/**
	 * Find all User entities.
	 * 
	 * @return List<User> all User entities
	 */
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		EntityManagerHelper.log("finding all User instances", Level.INFO, null);
		try {
			final String queryString = "select model from User model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}