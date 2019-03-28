package com.javasampleapproach.springjpa.compositeprimarykey.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.ManyToOne
import javax.persistence.Table

import com.fasterxml.jackson.annotation.JsonIgnore
 
@Entity
@Table(name="order_detail")
class OrderDetail(
	@Id
	@Column(name="order_id")
	var orderId: String = "",
	
	
	@JsonIgnore
    @ManyToOne
    @JoinColumns(JoinColumn(name = "brandcode", referencedColumnName = "brandcode"),
						JoinColumn(name = "customer_id", referencedColumnName = "customer_id"))
    var customer: Customer? = null,
	var product: String = ""
)