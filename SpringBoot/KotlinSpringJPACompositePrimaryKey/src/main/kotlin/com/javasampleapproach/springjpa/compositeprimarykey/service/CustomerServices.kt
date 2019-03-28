package com.javasampleapproach.springjpa.compositeprimarykey.service

import javax.transaction.Transactional
 
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
 
import com.javasampleapproach.springjpa.compositeprimarykey.model.Customer
import com.javasampleapproach.springjpa.compositeprimarykey.repository.CustomerRepository
 
@Service
public class CustomerServices {
	
	@Autowired
	lateinit var customerRepository: CustomerRepository
	
	fun deleteAll(){
		customerRepository.deleteAll()
	}
	
	fun save(customer: Customer){
		customerRepository.save(customer)
		customerRepository.flush()
	}
	
	@Transactional
	fun showAll(){
		val custs = customerRepository.findAll()
		custs.forEach{println(it)}
	}
}