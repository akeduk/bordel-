package com.instinctools.bordel.services;

import com.instinctools.bordel.dao.EmployeeDao;
import com.instinctools.bordel.dao.ServiceDao;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/employees")
@Produces("application/json")
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ServiceDao serviceDao;

    @GET
    public Response getAllEmployees(){

        List<Service> services = serviceDao.getAll();
        List<Employee> empl = employeeDao.getAll();
        return Response.status(200).entity(empl).build();
    }
}
