package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

/**
 * class containing implementation of interface method created on September 08,
 * 2018
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private final String SQL_UPDATE_PASSWORD = "update Employee set password = :password where emp_code= :emp_code";

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

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		List<Employee> employee = session.createQuery(criteria).getResultList();
		session.close();
		return employee;
	}

	@Override
	public Employee getEmployeeById(int emp_code) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		criteria.where(builder.equal(employeeRoot.get("emp_code"), emp_code));
		Employee employee = session.createQuery(criteria).getSingleResult();
		session.close();
		return employee;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaDelete<Employee> criteria = builder
				.createCriteriaDelete(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.where(builder.equal(employeeRoot.get("emp_code"),
				employee.getEmp_code()));
		try {
			tx = session.beginTransaction();
			session.createQuery(criteria).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteria = builder
				.createCriteriaUpdate(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);

		criteria.set(employeeRoot.get("first_name"), employee.getFirst_name())
				.where(builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("middle_name"), employee.getMiddle_name())
				.where(builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("dob"), employee.getDob()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("gender"), employee.getGender()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("primary_contact_number"),
				employee.getPrimary_contact_number()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("secondary_contact_number"),
				employee.getSecondary_contact_number()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("email_id"), employee.getEmail_id())
				.where(builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("skype_id"), employee.getSkype_id())
				.where(builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("profile_picture"),
				employee.getProfile_picture()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("password"),
				employee.getProfile_picture()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("skills"),
				employee.getProfile_picture()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));
		criteria.set(employeeRoot.get("enable"), employee.getEnable()).where(
				builder.equal(employeeRoot.get("emp_code"),
						employee.getEmp_code()));

		try {
			tx = session.beginTransaction();
			session.createQuery(criteria).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

	@Override
	public void createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}