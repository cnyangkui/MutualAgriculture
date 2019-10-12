package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Machineowner entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Machineowner
 * @author MyEclipse Persistence Tools
 */
public class MachineownerDAO implements IMachineownerDAO {
	// property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String VALID = "valid";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Machineowner entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MachineownerDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Machineowner entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Machineowner entity) {
		EntityManagerHelper.log("saving Machineowner instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Machineowner entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MachineownerDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Machineowner entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Machineowner entity) {
		EntityManagerHelper.log("deleting Machineowner instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Machineowner.class,
					entity.getOwnerId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Machineowner entity and return it or a copy of
	 * it to the sender. A copy of the Machineowner entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = MachineownerDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Machineowner entity to update
	 * @return Machineowner the persisted Machineowner entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Machineowner update(Machineowner entity) {
		EntityManagerHelper.log("updating Machineowner instance", Level.INFO,
				null);
		try {
			Machineowner result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Machineowner findById(Integer id) {
		EntityManagerHelper.log("finding Machineowner instance with id: " + id,
				Level.INFO, null);
		try {
			Machineowner instance = getEntityManager().find(Machineowner.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Machineowner entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Machineowner property to query
	 * @param value
	 *            the property value to match
	 * @return List<Machineowner> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Machineowner> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding Machineowner instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Machineowner model where model."
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

	public List<Machineowner> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Machineowner> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<Machineowner> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Machineowner> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Machineowner> findByValid(Object valid) {
		return findByProperty(VALID, valid);
	}

	/**
	 * Find all Machineowner entities.
	 * 
	 * @return List<Machineowner> all Machineowner entities
	 */
	@SuppressWarnings("unchecked")
	public List<Machineowner> findAll() {
		EntityManagerHelper.log("finding all Machineowner instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Machineowner model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}