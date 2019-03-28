package com.javasampleapproach.onetomany

import com.javasampleapproach.onetomany.model.Company
import com.javasampleapproach.onetomany.model.Product
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan(basePackageClasses = arrayOf(Company::class , Product::class))
@EnableJpaRepositories(basePackageClasses = arrayOf(KotlinSpringJpaOneToManyApplication::class))

class KotlinSpringJpaOneToManyApplication

fun main(args: Array<String>){
    SpringApplication.run(KotlinSpringJpaOneToManyApplication::class.java, *args)
}
