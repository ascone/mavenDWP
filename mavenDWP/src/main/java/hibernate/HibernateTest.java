package hibernate;

import java.util.List;

import org.hibernate.*;

import domain.Department;
import domain.Employee;

public class HibernateTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Department department =new Department("java");
		session.save(department);
		
		session.save(new Employee("Jacob Gibz",department));
		session.save(new Employee("nemo",department));
		
		session.getTransaction().commit();
		
		Query q = session.createQuery("From Employee");
		List<Employee> resultList=q.list();
		System.out.println("num of employees"+resultList.size());
		for(Employee next:resultList){
			System.out.println("next employee "+next.getName());
		}
		
	}

}
