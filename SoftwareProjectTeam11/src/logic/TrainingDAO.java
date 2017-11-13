package logic;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaQuery;

public class TrainingDAO extends Connection {
	
	public TrainingDAO() {
		super();
	}
	
	public List<Training> getAll(){
		
		List<Training> trainings;
		
		TypedQuery<Training> query = s.createQuery("FROM Training");
		trainings = query.getResultList();
		this.finalize();
		return trainings;
	}
	
	public Employee searchEmployeeById(int id) {
		List<Employee> employees;
		
		Query query = s.createQuery("FROM Training WHERE employeeId = " + id);
		employees = query.list();
	}
}
