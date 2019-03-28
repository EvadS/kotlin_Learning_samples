package com.javasampleapproach.kotlin.manytomany.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.javasampleapproach.kotlin.manytomany.model.Subject

@Repository
interface SubjectRepository : JpaRepository<Subject, Long>{
}