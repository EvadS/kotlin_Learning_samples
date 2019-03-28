package com.javasampleapproach.kotlin.manytomany.repo

import com.javasampleapproach.kotlin.manytomany.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long>{
}
