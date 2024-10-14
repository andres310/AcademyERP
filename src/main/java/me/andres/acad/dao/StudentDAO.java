package me.andres.acad.dao;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.transaction.Transactional;
import me.andres.acad.entity.Student;

@RequestScoped
public class StudentDAO extends DAOImpl<Student, Integer> {

    @Override
    public Class<Student> getDAOClass() {
        return Student.class;
    }
}
