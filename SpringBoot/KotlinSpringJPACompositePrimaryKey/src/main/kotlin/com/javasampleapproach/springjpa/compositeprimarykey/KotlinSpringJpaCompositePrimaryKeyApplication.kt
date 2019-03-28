package com.javasampleapproach.springjpa.compositeprimarykey

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.CommandLineRunner

import com.javasampleapproach.springjpa.compositeprimarykey.model.*
import com.javasampleapproach.springjpa.compositeprimarykey.service.CustomerServices
import com.javasampleapproach.springjpa.compositeprimarykey.service.OrderServices

import org.springframework.context.annotation.Bean

@SpringBootApplication
class KotlinSpringJpaCompositePrimaryKeyApplication{
	@Autowired
	lateinit var customerService: CustomerServices
	
	@Autowired
	lateinit var orderServices: OrderServices
	
	@Bean
	fun run() = CommandLineRunner {
		//deleteAll()
		//saveData()
		//showAll()
	}
	
	fun deleteAll(){
		println("---> Delete Customers")
		orderServices.deleteAll()
		customerService.deleteAll()
	}
	
	fun saveData(){
		println("---> Store Customers")
		// ===============Create customers===============
		// 1. Jack
		val jackId = CustomerId(1000, "azc")
		val jack = Customer(jackId, "A & Z", "Jack")
		
		val jackIphoneOrder = OrderDetail("001", jack, "IPhone 7")
		val jackIPadMiniOrder = OrderDetail("002", jack, "IPad Mini 2")
		
		val jackOrderDetails = setOf(jackIphoneOrder, jackIPadMiniOrder)
		jack.orderDetails = jackOrderDetails
		
		// 2. Mary
		val maryId = CustomerId(2000, "mkl")
		val mary = Customer(maryId, "Fashion Company", "Mary")
		
		val maryNote7Order = OrderDetail("003", mary, "Samsung Galaxy Note 7")
		
		val maryOrderDetails = setOf(maryNote7Order)
		mary.orderDetails = maryOrderDetails
		
		// ===============Saving to DB===============
		customerService.save(jack)
		customerService.save(mary)
	}
	
	fun showAll(){
		println("---> Show Customers' Info")
		customerService.showAll()
	}
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringJpaCompositePrimaryKeyApplication::class.java, *args)
}
