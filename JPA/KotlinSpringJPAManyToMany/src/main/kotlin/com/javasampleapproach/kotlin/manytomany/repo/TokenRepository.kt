package com.javasampleapproach.kotlin.manytomany.repo


import com.javasampleapproach.kotlin.manytomany.model.Token
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TokenRepository : JpaRepository<Token, String> {
   // @Query("Select o from Order o inner join fetch o.customer as customer left join fetch o.user as user where customer.id= :token")
   // fun findByToken(@Param("token") token: String): List<ComunicationToken>
}