package com.instinctools.bordel.resources;

import com.instinctools.bordel.dao.ServiceDao;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.services.EmployeeService;
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
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GET
    @Path("{id}")
    public Response getEmployee(@PathParam("id")final Long id) {
        Response response;
        Employee employee = employeeService.get(id);

        if (employee != null) {
            response = Response.status(Response.Status.ACCEPTED).entity(employee).build();
        } else {
            response =  Response.status(Response.Status.NOT_FOUND).entity("NOT FOUND").build();
        }

        return response;
    }

    @GET
    public Response getAllEmployees() {
        List<Employee> employees = employeeService.getAll();

        return Response.status(Response.Status.ACCEPTED).entity(employees).build();
    }

    @POST
    public Response saveEmployee(final Employee employee) {
        Long id = employeeService.save(employee).getId();

        return Response.status(Response.Status.ACCEPTED).entity(id).build();
    }

    @PUT
    public Response insertEmployee(final Employee employee) {
        Long id = employeeService.save(employee).getId();

        return Response.status(Response.Status.ACCEPTED).entity(id).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteEmployee(@PathParam("id")final Long id) {

        Response response;
        Employee employee = employeeService.remove(id);

        if (employee != null) {
            response = Response.status(Response.Status.ACCEPTED).entity(id).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).entity("NOT FOUND").build();
        }

        return response;
    }
}
