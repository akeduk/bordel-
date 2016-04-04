import com.instinctools.bordel.dao.GenericDao;
import com.instinctools.bordel.model.Client;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.dao.hibernate.ClientDao;
import com.instinctools.bordel.dao.hibernate.ClientDaoHibernate;
import com.instinctools.bordel.dao.hibernate.EmployeeDaoHibernate;

import java.util.List;

/**
 * Created by mack on 28.03.2016.
 */
public class TestHiber {
    public static final void main(String[] args){

        GenericDao<Employee, Long> employeeDao = new EmployeeDaoHibernate(Employee.class);

        List<Employee> employees = employeeDao.getAll();

        for (Employee employee: employees) {

            System.out.println(employee.getName());
        }

        ClientDao clientDao = new ClientDaoHibernate(Client.class);
        List<Client> clients = clientDao.getByPreferences("Oral");

        for (Client client: clients) {
            System.out.println(client.getSex());
        }
    }
}
