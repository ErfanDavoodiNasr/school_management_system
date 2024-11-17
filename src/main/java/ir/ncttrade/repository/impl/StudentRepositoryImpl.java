package ir.ncttrade.repository.impl;

import ir.ncttrade.base.AbstractBaseRepository;
import ir.ncttrade.model.Student;
import ir.ncttrade.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static ir.ncttrade.util.EntityManagerProvider.getEntityManager;


public class StudentRepositoryImpl extends AbstractBaseRepository<Student, Integer> implements StudentRepository {
    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public String getEntityQuery() {
        return "Student";
    }

    @Override
    public List<Student> findByNationalCode(String nationalCode) {
        EntityManager em = getEntityManager();
        try{
            TypedQuery<Student> results = em.createNamedQuery("Student.findByNationalCode", Student.class);
            results.setParameter(1,nationalCode);
            return results.getResultList();
        }catch (Exception e){
            throw new RuntimeException("no student found");
        }finally {
            em.close();
        }
    }

    @Override
    public Integer getCountStudent() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT count(s) from Student s");
        Long result = (Long) query.getResultList().get(0);
        return result.intValue();
    }
}
