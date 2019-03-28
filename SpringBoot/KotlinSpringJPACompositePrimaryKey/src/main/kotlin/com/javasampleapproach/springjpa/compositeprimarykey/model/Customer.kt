package com.javasampleapproach.springjpa.compositeprimarykey.model

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.OneToMany

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
  
@Entity
class Customer(
	@EmbeddedId
	var customerId: CustomerId? = null,
	var company: String = "",
	var name: String = "",
	
	@OneToMany(mappedBy = "customer", cascade = arrayOf(CascadeType.ALL))
    var orderDetails: Set<OrderDetail>? = null
){
	override fun toString(): String{
		val mapper = ObjectMapper()
		mapper.enable(SerializationFeature.INDENT_OUTPUT)
		val jsonString = mapper.writeValueAsString(this)
		return jsonString 
	}
}