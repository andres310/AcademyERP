package me.andres.acad.service;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.andres.acad.entity.Student;

@Stateless
public class StudentService {
    
    @PersistenceContext(unitName = "myPersistenceUnit")
    private EntityManager em;

    public void save(Student s) {
        em.persist(s);
    }

    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }
}
