package com.geowind.hunong.jpa;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Insectcontrol entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see com.geowind.hunong.jpa.Insectcontrol
 * @author MyEclipse Persistence Tools
 */
public class InsectcontrolDAO implements IInsectcontrolDAO {
	// property constants
	public static final String DESCR = "descr";
	public static final String UPLOAD_IMAGE = "uploadImage";
	public static final String UPLOADTIME = "uploadtime";
	public static final String INSECT_IMAGE = "insectImage";
	public static final String INFO = "info";
	public static final String HARM = "harm";
	public static final String COUNTERPLAN = "counterplan";
	public static final String SOLVETIME = "solvetime";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Insectcontrol entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * InsectcontrolDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Insectcontrol entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Insectcontrol entity) {
		EntityManagerHelper.log("saving Insectcontrol instance", Level.INFO,
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
	 * Delete a persistent Insectcontrol entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * InsectcontrolDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Insectcontrol entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Insectcontrol entity) {
		EntityManagerHelper.log("deleting Insectcontrol instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Insectcontrol.class,
					entity.getCid());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Insectcontrol entity and return it or a copy
	 * of it to the sender. A copy of the Insectcontrol entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = InsectcontrolDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Insectcontrol entity to update
	 * @return Insectcontrol the persisted Insectcontrol entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Insectcontrol update(Insectcontrol entity) {
		EntityManagerHelper.log("updating Insectcontrol instance", Level.INFO,
				null);
		try {
			Insectcontrol result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Insectcontrol findById(Integer id) {
		EntityManagerHelper.log(
				"finding Insectcontrol instance with id: " + id, Level.INFO,
				null);
		try {
			Insectcontrol instance = getEntityManager().find(
					Insectcontrol.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Insectcontrol entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Insectcontrol property to query
	 * @param value
	 *            the property value to match
	 * @return List<Insectcontrol> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Insectcontrol> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding Insectcontrol instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Insectcontrol model where model."
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

	public List<Insectcontrol> findByDescr(Object descr) {
		return findByProperty(DESCR, descr);
	}

	public List<Insectcontrol> findByUploadImage(Object uploadImage) {
		return findByProperty(UPLOAD_IMAGE, uploadImage);
	}

	public List<Insectcontrol> findByUploadtime(Object uploadtime) {
		return findByProperty(UPLOADTIME, uploadtime);
	}

	public List<Insectcontrol> findByInsectImage(Object insectImage) {
		return findByProperty(INSECT_IMAGE, insectImage);
	}

	public List<Insectcontrol> findByInfo(Object info) {
		return findByProperty(INFO, info);
	}

	public List<Insectcontrol> findByHarm(Object harm) {
		return findByProperty(HARM, harm);
	}

	public List<Insectcontrol> findByCounterplan(Object counterplan) {
		return findByProperty(COUNTERPLAN, counterplan);
	}

	public List<Insectcontrol> findBySolvetime(Object solvetime) {
		return findByProperty(SOLVETIME, solvetime);
	}

	public List<Insectcontrol> findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	/**
	 * Find all Insectcontrol entities.
	 * 
	 * @return List<Insectcontrol> all Insectcontrol entities
	 */
	@SuppressWarnings("unchecked")
	public List<Insectcontrol> findAll() {
		EntityManagerHelper.log("finding all Insectcontrol instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Insectcontrol model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}