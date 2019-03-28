package com.javasampleapproach.kotlin.manytomany.model

import javax.persistence.*

@Entity
data class Token
(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var token_id: Long = -1,
        var token: String = "",


        @ManyToMany(mappedBy = "tokens")
        var nodeInfoContainers: List<NodeInfoContainer> = mutableListOf<NodeInfoContainer>()
)
