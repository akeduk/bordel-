import com.instinctools.bordel.dao.EmployeeDao;
import com.instinctools.bordel.dao.GenericDao;
import com.instinctools.bordel.dao.ServiceDao;
import com.instinctools.bordel.dao.hibernate.AbstractDaoHibernate;
import com.instinctools.bordel.dao.hibernate.ServiceDaoHibernate;
import com.instinctools.bordel.model.Client;
import com.instinctools.bordel.model.Employee;
import com.instinctools.bordel.dao.ClientDao;
import com.instinctools.bordel.dao.hibernate.ClientDaoHibernate;
import com.instinctools.bordel.dao.hibernate.EmployeeDaoHibernate;
import com.instinctools.bordel.model.Manager;
import com.instinctools.bordel.model.Office;
import com.instinctools.bordel.model.Service;
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

        ServiceDao serviceDao = new ServiceDaoHibernate(Service.class);
        List<Service> services = serviceDao.getAll();

        for (Service service: services) {
            System.out.println(service.getAddress() + " ");
            System.out.println(service.getCost() + " ");
            System.out.println(service.getClient().getName() + " ");
            System.out.println(service.getEmployee().getName() + " ");
        }
    }
}
