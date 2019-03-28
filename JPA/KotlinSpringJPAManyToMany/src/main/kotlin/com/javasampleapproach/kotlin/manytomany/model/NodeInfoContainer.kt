package com.javasampleapproach.kotlin.manytomany.model

import java.time.Instant
import javax.persistence.*

@Entity
data class NodeInfoContainer(

        @Id var nodeInfoId: String = "",
        var fileName: String = "nodeInfo",
        var lastUpdateDate: Instant = Instant.now(),
        var token: String= "",

        @ManyToMany(cascade = arrayOf(CascadeType.ALL),fetch = FetchType.LAZY)
        @JoinTable(name = "test4",
                joinColumns = arrayOf(JoinColumn(name = "nodeInfoId", referencedColumnName = "nodeInfoId")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "tokenId", referencedColumnName = "token_id")))

        var tokens: List<Token> = mutableListOf<Token>()
)