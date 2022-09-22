package com.tts.h2explore.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.h2explore.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	ArrayList<Customer> findByLastName(String lastName);
}
