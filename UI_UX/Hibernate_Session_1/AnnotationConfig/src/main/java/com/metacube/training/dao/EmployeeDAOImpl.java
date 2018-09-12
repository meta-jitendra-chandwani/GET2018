package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private final String SQL_FIND_PROJECT = "from Employee where emp_code = :emp_code";
	private final String SQL_GET_ALL = "from Employee";
	private final String SQL_DELETE_PROJECT = "delete from Employee where emp_code = :emp_code";
	private final String SQL_UPDATE_PROJECT = "update Employee set first_name = :first_name, middle_name  = :middle_name, "
			+ "dob=:dob,gender=:gender,primary_contact_number=:primary_contact_number,secondary_contact_number=:secondary_contact_number,"
			+ "email_id=:email_id,skype_id = :skype_id,skills=:skills,enable=:enable,password=:password where emp_code = :emp_code";

	private final String SQL_UPDATE_PASSWORD = "update Employee set password = :password where emp_code= :emp_code";

	@Override
	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_GET_ALL);
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(int emp_code) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_FIND_PROJECT);
		query.setParameter("emp_code", emp_code);
		return query.getSingleResult();
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_DELETE_PROJECT);
		query.setParameter("emp_code", employee.getEmp_code());
		return (query.executeUpdate() > 0);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_PROJECT);
		query.setParameter("first_name", employee.getFirst_name());
		query.setParameter("middle_name", employee.getMiddle_name());
		query.setParameter("dob", employee.getDob());
		query.setParameter("gender", employee.getGender());
		query.setParameter("primary_contact_number",
				employee.getPrimary_contact_number());
		query.setParameter("secondary_contact_number",
				employee.getSecondary_contact_number());
		query.setParameter("email_id", employee.getEmail_id());
		query.setParameter("skype_id", employee.getSkype_id());
		query.setParameter("skills", employee.getSkills());
		query.setParameter("enable", employee.getEnable());
		query.setParameter("password", employee.getPassword());
		query.setParameter("emp_code", employee.getEmp_code());
		return (query.executeUpdate() > 0);
	}

	@Override
	public void createEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public boolean validateUser(int emp_code, String password) {
		return getEmployeeById(emp_code).getPassword().equals(password);		
	}

	@Override
	public boolean updateUserPassword(int emp_code, String password) {
		TypedQuery<Employee> query = sessionFactory.getCurrentSession()
				.createQuery(SQL_UPDATE_PASSWORD);
		query.setParameter("password", password);
		query.setParameter("emp_code", emp_code);

		return (query.executeUpdate() > 0);

	}
}