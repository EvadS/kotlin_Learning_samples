package com.javasampleapproach.springjpa.compositeprimarykey.repository

import org.springframework.data.jpa.repository.JpaRepository
 
import com.javasampleapproach.springjpa.compositeprimarykey.model.Customer
import com.javasampleapproach.springjpa.compositeprimarykey.model.CustomerId

interface CustomerRepository: JpaRepository<Customer, CustomerId>