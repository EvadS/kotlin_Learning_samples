package com.javasampleapproach.kotlin.manytomany.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany


@Entity
//@Table(name = "subject")
data class Subject2(
        @Id
        var subjectid: String = "", //Long = -1,

        var name: String = "",

        @ManyToMany(mappedBy = "subjects")
        var students: List<Student> = mutableListOf<Student>()
) {
   /* override fun toString(): String {
        return "{subject: ${this.name}, nodeInfoContainers: ${nodeInfoContainers.map { it -> it.name }}}";
    }*/
}