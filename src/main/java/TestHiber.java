import com.instinctools.bordel.dao.EmployeeDao;
import com.instinctools.bordel.dao.GenericDao;
import com.instinctools.bordel.dao.hibernate.AbstractDaoHibernate;
import com.instinctools.bordel.model.Client;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.dao.ClientDao;
import com.instinctools.bordel.dao.hibernate.ClientDaoHibernate;
import com.instinctools.bordel.dao.hibernate.EmployeeDaoHibernate;
import com.instinctools.bordel.model.Manager;
import com.instinctools.bordel.model.Office;
import com.instinctools.bordel.model.Sex;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by mack on 28.03.2016.
 */
public class TestHiber {
    public static final void main(String[] args){

//        GenericDao<Office, Long> officeDao = new AbstractDaoHibernate<Office, Long>(Office.class);
//        Office office = officeDao.getAll().get(0);

//        GenericDao<Manager, Long> managerDao = new AbstractDaoHibernate<Manager, Long>(Manager.class);
//        Manager manager = managerDao.getAll().get(0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        EmployeeDao employeeDao = new EmployeeDaoHibernate(Employee.class);
        List<Employee> employees = employeeDao.getAll();

        for (Employee employee: employees) {
            System.out.println(employee.getName() + " " + sdf.format(employee.getBirthday().getTime()));
            System.out.print("---");
            System.out.println(employee.getNickname());
        }

        ClientDao clientDao = new ClientDaoHibernate(Client.class);

        List<Client> clients = clientDao.getAll();
//
        for (Client client: clients) {
            System.out.println(client.getName() + " " + sdf.format(client.getBirthday().getTime()));
        }
    }
}
