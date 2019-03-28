package com.javasampleapproach.kotlin.manytomany.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
//@Table(name = "subject")
data class Subject(
        @Id
        var subjectid: String = "", //Long = -1,

        var name: String = "",

        @ManyToMany(mappedBy = "subjects")
        var students: List<Student> = mutableListOf<Student>()
) /*{
    override fun toString(): String {
        return "{subject: ${this.name}, nodeInfoContainers: ${nodeInfoContainers.map { it -> it.name }}}";
    }
}*/