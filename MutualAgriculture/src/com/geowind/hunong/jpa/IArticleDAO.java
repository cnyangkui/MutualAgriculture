package com.geowind.hunong.jpa;

import java.util.List;

/**
 * Interface for ArticleDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IArticleDAO {
	/**
	 * Perform an initial save of a previously unsaved Article entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IArticleDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Article entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Article entity);

	/**
	 * Delete a persistent Article entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IArticleDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Article entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Article entity);

	/**
	 * Persist a previously saved Article entity and return it or a copy of it
	 * to the sender. A copy of the Article entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IArticleDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Article entity to update
	 * @return Article the persisted Article entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Article update(Article entity);

	public Article findById(Integer id);

	/**
	 * Find all Article entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Article property to query
	 * @param value
	 *            the property value to match
	 * @return List<Article> found by query
	 */
	public List<Article> findByProperty(String propertyName, Object value);

	public List<Article> findByClassification(Object classification);

	public List<Article> findByTitle(Object title);

	public List<Article> findByList(Object list);

	public List<Article> findBySummary(Object summary);

	public List<Article> findByKeyword(Object keyword);

	public List<Article> findByContent(Object content);

	public List<Article> findByImgUrl(Object imgUrl);

	public List<Article> findByVideoUrl(Object videoUrl);

	public List<Article> findByOther(Object other);

	/**
	 * Find all Article entities.
	 * 
	 * @return List<Article> all Article entities
	 */
	public List<Article> findAll();
}