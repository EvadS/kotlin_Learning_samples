package com.javasampleapproach.springjpa.compositeprimarykey.repository

import org.springframework.data.jpa.repository.JpaRepository
 
import com.javasampleapproach.springjpa.compositeprimarykey.model.OrderDetail

interface OrderRepository: JpaRepository<OrderDetail, Int>