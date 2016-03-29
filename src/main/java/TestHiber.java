import com.instinctools.bordel.model.Client;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.model.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by mack on 28.03.2016.
 */
public class TestHiber {
    public static final void main(String[] args){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(Employee.class);

        List<Employee> employees = (List<Employee>)criteria.list();

        for (Employee employee: employees) {
            Person manager = employee.getManager();
            System.out.print(manager.getName());
        }
    }
}
