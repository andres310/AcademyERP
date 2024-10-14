package me.andres.acad.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.andres.acad.dao.StudentDAO;
import me.andres.acad.entity.Student;

@ApplicationScoped
public class StudentService extends GenericServiceImpl<Student, Integer> implements IStudentService {

    private final StudentDAO dao;

    @Inject
    public StudentService(StudentDAO dao) {
        super(Student.class);
        this.dao = dao;
    }

    @Override
    public StudentDAO getDAO() {
        return dao;
    }
}
