package com.geowind.hunong.jpa;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Task
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Task
 * @author MyEclipse Persistence Tools
 */
public class TaskDAO implements ITaskDAO {
	// property constants
	public static final String WORKLOAD = "workload";
	public static final String TYPE = "type";
	public static final String FINISHED = "finished";
	public static final String DESCR = "descr";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Task entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TaskDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Task entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Task entity) {
		EntityManagerHelper.log("saving Task instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Task entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * TaskDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Task entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Task entity) {
		EntityManagerHelper.log("deleting Task instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Task.class,
					entity.getTaskId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Task entity and return it or a copy of it to
	 * the sender. A copy of the Task entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = TaskDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Task entity to update
	 * @return Task the persisted Task entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Task update(Task entity) {
		EntityManagerHelper.log("updating Task instance", Level.INFO, null);
		try {
			Task result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Task findById(Integer id) {
		EntityManagerHelper.log("finding Task instance with id: " + id,
				Level.INFO, null);
		try {
			Task instance = getEntityManager().find(Task.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Task entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Task property to query
	 * @param value
	 *            the property value to match
	 * @return List<Task> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Task> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Task instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Task model where model."
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

	public List<Task> findByWorkload(Object workload) {
		return findByProperty(WORKLOAD, workload);
	}

	public List<Task> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Task> findByFinished(Object finished) {
		return findByProperty(FINISHED, finished);
	}

	public List<Task> findByDescr(Object descr) {
		return findByProperty(DESCR, descr);
	}

	/**
	 * Find all Task entities.
	 * 
	 * @return List<Task> all Task entities
	 */
	@SuppressWarnings("unchecked")
	public List<Task> findAll() {
		EntityManagerHelper.log("finding all Task instances", Level.INFO, null);
		try {
			final String queryString = "select model from Task model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}