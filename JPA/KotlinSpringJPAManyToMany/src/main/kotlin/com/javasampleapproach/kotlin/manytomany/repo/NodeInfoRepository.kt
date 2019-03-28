package com.javasampleapproach.kotlin.manytomany.repo


import com.javasampleapproach.kotlin.manytomany.model.Token
import com.javasampleapproach.kotlin.manytomany.model.NodeInfoContainer
import org.springframework.data.jpa.repository.EntityGraph

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.Instant


@Repository
interface NodeInfoRepository : JpaRepository<NodeInfoContainer, String> {

    fun findFirstByNodeInfoId(clientId : String ): NodeInfoContainer
}