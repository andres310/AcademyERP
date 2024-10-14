package me.andres.acad.resource;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import me.andres.acad.entity.Student;
import me.andres.acad.service.IStudentService;
import me.andres.acad.service.StudentService;

import java.util.List;

@Path("students")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class StudentResource {

    @Inject
    private IStudentService service;

    /*@Inject
    public StudentResource(IStudentService service) {
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

    @PUT
    public void update(Student s) {
        service.save(s);
    }

    @DELETE
    @Path("/{id}")
    public String delete(@PathParam("id") Integer id) {
        return "deleted";
    }
}
