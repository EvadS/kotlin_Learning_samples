package com.javasampleapproach.kotlin.manytomany.model

import java.time.Instant
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
data class Student(


        @Id var clientId: String = "",
        var fileName: String = "nodeInfo",
        var lastUpdateDate: Instant = Instant.now(),
        var token: String = "",


        @ManyToMany(cascade = arrayOf(CascadeType.ALL))
        @JoinTable(name = "test_node",
                joinColumns = arrayOf(JoinColumn(name = "clientId", referencedColumnName = "clientId")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "subjectid", referencedColumnName = "subjectid")))

        var subjects: List<Subject> = mutableListOf<Subject>()


        )