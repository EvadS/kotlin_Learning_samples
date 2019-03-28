package com.javasampleapproach.onetomany.model

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity @Table(name = "company")
data class Company(
    var name: String = "",
    
    @OneToMany(mappedBy = "company",
			cascade = arrayOf(CascadeType.ALL),
			fetch = FetchType.EAGER)
    var products: List<Product> = emptyList(),
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long = 0
){
	override fun toString(): String{
		return "{name: ${this.name}, products: ${products.map { it->it.name }}}";
	}
}