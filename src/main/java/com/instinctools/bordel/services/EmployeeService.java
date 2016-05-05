package com.instinctools.bordel.services;

import com.instinctools.bordel.dao.EmployeeDao;
import com.instinctools.bordel.dao.ServiceDao;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/employees")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ServiceDao serviceDao;

    @GET
    @Path("{id}")
    @Consumes("application/text")
    public Response getEmployee(@PathParam("id")final Long id) {

        Employee employee = employeeDao.get(id);

        if (employee != null) {
            return Response.status(Response.Status.ACCEPTED).entity(employee).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("NOT FOUND").build();
        }
    }

    @GET
    public Response getAllEmployees() {

        List<Service> services = serviceDao.getAll();
        List<Employee> empl = employeeDao.getAll();
        return Response.status(Response.Status.ACCEPTED).entity(empl).build();
    }

    @POST
    @Produces("application/text")
    @Consumes("application/text")
    public Response saveEmployee(final Employee employee) {

        Long id = employeeDao.save(employee).getId();
        return Response.status(Response.Status.ACCEPTED).entity(id).build();
    }

    @PUT
    @Produces("application/text")
    @Consumes("application/text")
    public Response insertEmployee(final Employee employee) {

        Long id = employeeDao.save(employee).getId();
        return Response.status(Response.Status.ACCEPTED).entity(id).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/text")
    @Consumes("application/text")
    public Response deleteEmployee(@PathParam("id")final Long id) {

        Employee employee = employeeDao.get(id);
        if (employee != null) {
            employeeDao.remove(employee);
            return Response.status(Response.Status.ACCEPTED).entity(id).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("NOT FOUND").build();
        }
    }
}
