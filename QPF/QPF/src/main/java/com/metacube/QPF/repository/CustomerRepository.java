package com.metacube.QPF.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.metacube.QPF.model.Customer;
 
 
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByAge(int age);
}
