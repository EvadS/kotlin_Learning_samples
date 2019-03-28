package com.javasampleapproach.springjpa.compositeprimarykey.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
 
import com.javasampleapproach.springjpa.compositeprimarykey.model.OrderDetail
import com.javasampleapproach.springjpa.compositeprimarykey.repository.OrderRepository
 
@Service
class OrderServices {
	
	@Autowired
	lateinit var orderRepository: OrderRepository
	
	fun save(order: OrderDetail){
		orderRepository.save(order)
	}
	
	fun deleteAll(){
		orderRepository.deleteAll()
	}
}