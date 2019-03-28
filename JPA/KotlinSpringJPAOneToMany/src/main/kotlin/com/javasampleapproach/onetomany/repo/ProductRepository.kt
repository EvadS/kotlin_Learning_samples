package com.javasampleapproach.onetomany.repo


import com.javasampleapproach.onetomany.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>{
}