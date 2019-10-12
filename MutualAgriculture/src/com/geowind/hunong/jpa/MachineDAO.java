package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Machine entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see com.geowind.hunong.jpa.Machine
 * @author MyEclipse Persistence Tools
 */
public class MachineDAO implements IMachineDAO {
	// property constants
	public static final String PLATE = "plate";
	public static final String TYPE = "type";
	public static final String BRAND = "brand";
	public static final String HORSEPOWER = "horsepower";
	public static final String EFFICIENCY = "efficiency";
	public static final String PICTURE = "picture";
	public static final String STATE = "state";
	public static final String WORKSTATE = "workstate";
	public static final String VALID = "valid";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Machine entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MachineDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Machine entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Machine entity) {
		EntityManagerHelper.log("saving Machine instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Machine entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * MachineDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Machine entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Machine entity) {
		EntityManagerHelper.log("deleting Machine instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Machine.class,
					entity.getMachineId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Machine entity and return it or a copy of it
	 * to the sender. A copy of the Machine entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = MachineDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Machine entity to update
	 * @return Machine the persisted Machine entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Machine update(Machine entity) {
		EntityManagerHelper.log("updating Machine instance", Level.INFO, null);
		try {
			Machine result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Machine findById(Integer id) {
		EntityManagerHelper.log("finding Machine instance with id: " + id,
				Level.INFO, null);
		try {
			Machine instance = getEntityManager().find(Machine.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Machine entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Machine property to query
	 * @param value
	 *            the property value to match
	 * @return List<Machine> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Machine> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Machine instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Machine model where model."
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

	public List<Machine> findByPlate(Object plate) {
		return findByProperty(PLATE, plate);
	}

	public List<Machine> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Machine> findByBrand(Object brand) {
		return findByProperty(BRAND, brand);
	}

	public List<Machine> findByHorsepower(Object horsepower) {
		return findByProperty(HORSEPOWER, horsepower);
	}

	public List<Machine> findByEfficiency(Object efficiency) {
		return findByProperty(EFFICIENCY, efficiency);
	}

	public List<Machine> findByPicture(Object picture) {
		return findByProperty(PICTURE, picture);
	}

	public List<Machine> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Machine> findByWorkstate(Object workstate) {
		return findByProperty(WORKSTATE, workstate);
	}

	public List<Machine> findByValid(Object valid) {
		return findByProperty(VALID, valid);
	}

	/**
	 * Find all Machine entities.
	 * 
	 * @return List<Machine> all Machine entities
	 */
	@SuppressWarnings("unchecked")
	public List<Machine> findAll() {
		EntityManagerHelper.log("finding all Machine instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Machine model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}