package me.andres.acad.resource;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import me.andres.acad.entity.Student;
import me.andres.acad.service.StudentService;

import java.util.List;

@Path("students")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class StudentResource {

    @Inject
    private StudentService service;

    /*@Inject
    public StudentResource(StudentService service) {
        this.service = service;
    }*/
    
    @GET
    public List<Student> all() {
        return service.findAll();
    }

    @POST
    public void save(Student s) {
        service.save(s);
    }
}
