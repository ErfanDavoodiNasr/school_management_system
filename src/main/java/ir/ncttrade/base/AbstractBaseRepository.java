package ir.ncttrade.base;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static ir.ncttrade.util.EntityManagerProvider.getEntityManager;

public abstract class AbstractBaseRepository<T extends BaseModel<ID>,ID extends Serializable> implements BaseRepository<T,ID> {
    @Override
    public ID save(T t) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return t.getId();
    }

    @Override
    public Boolean remove(ID id) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            T t = em.find(getEntityClass(), id);
            em.remove(t);
            em.getTransaction().commit();
            return Boolean.TRUE;
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return Boolean.FALSE;
    }


    @Override
    public T findById(ID id) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            T entity = em.find(getEntityClass(), id);
            em.getTransaction().commit();
            return entity;
        }catch (Exception e) {
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        return null;
    }

    public abstract Class<T> getEntityClass();
}
