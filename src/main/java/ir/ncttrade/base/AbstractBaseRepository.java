package ir.ncttrade.base;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

import static ir.ncttrade.util.EntityManagerProvider.getEntityManager;

public abstract class AbstractBaseRepository<T extends BaseModel<ID>, ID extends Serializable> implements BaseRepository<T, ID> {

    @Override
    public T upsert(T t) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return t;
    }

    @Override
    public Boolean remove(ID id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            T t = em.find(getEntityClass(), id);
            em.remove(t);
            em.getTransaction().commit();
            return Boolean.TRUE;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return Boolean.FALSE;
    }


    @Override
    public T findById(ID id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(getEntityClass(), id);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public List findAll() {
        String query = "SELECT e FROM " + getEntityQuery() + " e";
        EntityManager em = getEntityManager();
        List results = null;
        try {
            em.getTransaction().begin();
            Query q = em.createQuery(query);
            em.getTransaction().commit();
            results = q.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return results;
    }

    public abstract Class<T> getEntityClass();

    public abstract String getEntityQuery();
}
