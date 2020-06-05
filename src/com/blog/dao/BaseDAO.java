package com.blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public abstract class BaseDAO<T> {
   @PersistenceContext(unitName = "blog")
   private EntityManager entityManager;
   
   private Class<T> entityClass;
   
   public BaseDAO(Class<T> entityClass) {
      this.entityClass = entityClass;
   }
   
   protected EntityManager getEntityManager() {
      return this.entityManager;
   }
   
   public void create(T entity) {
      try {
         entityManager.getTransaction().begin();
         entityManager.persist(entity);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
   }
   
   public void update(T entity) {
      try {
         entityManager.getTransaction().begin();
         entityManager.merge(entity);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
   }
   
   public void delete(T entity) {
      try {
         entityManager.getTransaction().begin();
         entityManager.remove(entity);
         entityManager.getTransaction().commit();
      } catch (Exception ex) {
         ex.printStackTrace();
         entityManager.getTransaction().rollback();
      }
   }
   
   public T find(Object id) {
      return entityManager.find(entityClass, id);
   }
   
   public List<T> findAll() {
      CriteriaQuery<T> criteriaQuery = entityManager.
            getCriteriaBuilder().
            createQuery(entityClass);
      
      criteriaQuery.select(criteriaQuery.from(entityClass));
      
      return entityManager.createQuery(criteriaQuery).getResultList();
   }
   
   public void close() {
      entityManager.close();
   }
}
