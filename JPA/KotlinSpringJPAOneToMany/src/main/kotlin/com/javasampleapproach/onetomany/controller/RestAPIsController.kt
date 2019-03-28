package com.javasampleapproach.onetomany.controller

import com.javasampleapproach.onetomany.model.Company
import com.javasampleapproach.onetomany.model.Product
import com.javasampleapproach.onetomany.repo.CompanyRepository
import com.javasampleapproach.onetomany.repo.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class RestAPIsController {
	
	@Autowired
	lateinit var companyRepository: CompanyRepository
	
	@Autowired
	lateinit var productRepository: ProductRepository

	@RequestMapping("/save/1")
	fun save(): String {
		// clear data
		productRepository.deleteAll()
		companyRepository.deleteAll()
		
		// prepare Company data
		val apple = Company("Apple")
		val samsung = Company("Samsung")
		
		// save list of companies to database
		companyRepository.save(setOf(apple, samsung))
		
		// prepare Product data
		val iphone7 = Product("Iphone 7", apple)
		val iPadPro = Product("IPadPro", apple)
		
		val galaxyJ7 = Product("GalaxyJ7", samsung)
		val galaxyTabA = Product("GalaxyTabA", samsung)
		
		// save list of products to database
		productRepository.save(setOf(iphone7, iPadPro, galaxyJ7, galaxyTabA))
		
		return "saving with approach 1 - done!"
	}
	
	@RequestMapping("/save/2")
	fun save2(): String {
		// clear data
		productRepository.deleteAll()
		companyRepository.deleteAll()
		
		// prepare Company data
		val apple = Company("Apple")
		val samsung = Company("Samsung")
		
		// prepare Product data
		val iphone7 = Product("Iphone 7", apple)
		val iPadPro = Product("IPadPro", apple)
		
		val galaxyJ7 = Product("GalaxyJ7", samsung)
		val galaxyTabA = Product("GalaxyTabA", samsung)
		
		// set products for companies
		apple.products = listOf(iphone7, iPadPro)
		samsung.products = listOf(galaxyJ7, galaxyTabA)
		
		// save list of companies to database
		companyRepository.save(listOf(apple, samsung))
		
		return "saving with approach 2 - done!"
	}
	
	@RequestMapping("/companies")
	fun findAllCompanies() : String {
		// fetch all companies from database
		val companies = companyRepository.findAll()
		
		// some processing for better String format on browser showing 
		var info : String = ""
		companies.forEach{
			info += it.toString() + "<br>"
		}
		
		return info
	} 
	
	@RequestMapping("/products")
	fun findAllProducts() : String {
		// fetch all products from database
		val products = productRepository.findAll()
		
		// some processing codes for better String format on browser showing
		var info : String = ""
		
		products.forEach{
			info += it.toString() + "<br>"
		}
		
		return info
	} 
}