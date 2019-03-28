package com.javasampleapproach.onetomany.repo



import com.javasampleapproach.onetomany.model.Company
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : JpaRepository<Company, Long>{
}