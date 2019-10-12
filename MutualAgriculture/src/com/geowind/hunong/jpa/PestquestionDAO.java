package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Pestquestion entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Pestquestion
 * @author MyEclipse Persistence Tools
 */
public class PestquestionDAO implements IPestquestionDAO {
	// property constants
	public static final String UPLOAD_PIC = "uploadPic";
	public static final String DESCR = "descr";
	public static final String UTIME = "utime";
	public static final String ATIME = "atime";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Pestquestion entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PestquestionDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestquestion entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Pestquestion entity) {
		EntityManagerHelper.log("saving Pestquestion instance", Level.INFO,
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
	 * Delete a persistent Pestquestion entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PestquestionDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Pestquestion entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Pestquestion entity) {
		EntityManagerHelper.log("deleting Pestquestion instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Pestquestion.class,
					entity.getQid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Pestquestion entity and return it or a copy of
	 * it to the sender. A copy of the Pestquestion entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = PestquestionDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Pestquestion entity to update
	 * @return Pestquestion the persisted Pestquestion entity instance, may not
	 *         be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Pestquestion update(Pestquestion entity) {
		EntityManagerHelper.log("updating Pestquestion instance", Level.INFO,
				null);
		try {
			Pestquestion result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Pestquestion findById(Integer id) {
		EntityManagerHelper.log("finding Pestquestion instance with id: " + id,
				Level.INFO, null);
		try {
			Pestquestion instance = getEntityManager().find(Pestquestion.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Pestquestion entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Pestquestion property to query
	 * @param value
	 *            the property value to match
	 * @return List<Pestquestion> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Pestquestion> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log("finding Pestquestion instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Pestquestion model where model."
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

	public List<Pestquestion> findByUploadPic(Object uploadPic) {
		return findByProperty(UPLOAD_PIC, uploadPic);
	}

	public List<Pestquestion> findByDescr(Object descr) {
		return findByProperty(DESCR, descr);
	}

	public List<Pestquestion> findByUtime(Object utime) {
		return findByProperty(UTIME, utime);
	}

	public List<Pestquestion> findByAtime(Object atime) {
		return findByProperty(ATIME, atime);
	}

	public List<Pestquestion> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/**
	 * Find all Pestquestion entities.
	 * 
	 * @return List<Pestquestion> all Pestquestion entities
	 */
	@SuppressWarnings("unchecked")
	public List<Pestquestion> findAll() {
		EntityManagerHelper.log("finding all Pestquestion instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Pestquestion model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}