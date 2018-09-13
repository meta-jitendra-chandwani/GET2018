package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository<Employee> employeeRepository;

	@Override
	public Employee getEmployeeById(int emp_code) {
		return employeeRepository.findOne(emp_code);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteEmployee(int emp_code) {
		employeeRepository.delete(emp_code);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee.getFirst_name(),
				employee.getMiddle_name(), employee.getDob(),
				employee.getGender(), employee.getPrimary_contact_number(),
				employee.getSecondary_contact_number(), employee.getEmail_id(),
				employee.getSkype_id(), employee.getSkills(),
				employee.getEnable(), employee.getPassword(),
				employee.getEmp_code()) > 0;
	}

	@Override
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public boolean validateUser(int emp_code, String password) {
		return employeeRepository.findOne(emp_code).getPassword()
				.equals(password);
	}

	@Override
	public boolean updateUserPassword(int emp_code, String password) {
		return employeeRepository.updateUserPassword(password, emp_code) > 0;
	}

}
