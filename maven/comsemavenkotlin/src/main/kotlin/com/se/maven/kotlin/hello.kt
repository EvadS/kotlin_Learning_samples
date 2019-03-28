package com.se.maven.kotlin

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.kotlination.jsonstring.Base
import com.kotlination.jsonstring.Employer
import com.kotlination.jsonstring.Person
import java.util.*
import kotlin.reflect.KVisibility
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties

class Reflector {
    val Foo = 1

    fun printFields() {
        this::class.memberProperties.forEach {
            if (it.visibility == KVisibility.PUBLIC) {
                println(it.name)
                println(it.getter.call(this))
            }
        }
    }
}

fun main(args: Array<String>) {

    empToJson()
    toJson()


    var a = Reflector()
    a.printFields()

    toJson()
    fromJson()
    println("Hello, World")

    val person = Person("Kolineer", 27, listOf("I am Kotlin Learner", "At Kotlination"))

    // members
    val objClass = person.javaClass.kotlin
    var map3 = java.util.HashMap<String, String>()
    val objClass2 = person!!::class.members


    var personClass = person.javaClass.kotlin
    for (prop in objClass2) {
        map3.put(prop.name, "")
    }


    try {

        val objClass = person.javaClass.kotlin
        val props = objClass.memberProperties
        var sb = StringBuilder()
        sb.append("{")

        var map = HashMap<String, String>()

        var fields = objClass.declaredMemberProperties
        for (prop in fields) {
            sb.append(String.format("\"%s\":\"%s\" ,", prop.name, prop.get(person).toString()))
            println("${prop.name.padEnd(13)} -> ${prop.get(person)}")

            map.put(prop.name, prop.get(person).toString())
        }

        sb.append("}")

        //----------
        println("=======")
        println(sb.toString())
        println("======= 2 ")

        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonPerson: String = gson.toJson(person)
        println(jsonPerson)

    } catch (e: Exception) {
        e.printStackTrace()
    }

}

fun empToJson(){
    val gson = GsonBuilder().setPrettyPrinting().create()

    val empl = Employer("Kolineer", 27, listOf("I am Kotlin Learner", "At Kotlination"),125.25F)
    val jsonEmploye: String = gson.toJson(empl)
    println("Employer json " + jsonEmploye)
}


fun toJson() {
    val gson = GsonBuilder().setPrettyPrinting().create()

    val person = Person("Kolineer", 27, listOf("I am Kotlin Learner", "At Kotlination"))
    val jsonPerson: String = gson.toJson(person, Base::class.java)
    println(jsonPerson)
    //

    val props = Properties()
    props.setProperty("id", "11212") // (key, value)


    val jsonKeyValue: String = gson.toJson(props)
println("key value    : => "+jsonKeyValue)

}


fun toJson2() {
    val gson = GsonBuilder().setPrettyPrinting().create()

    var test: Any
    val person = Person("Kolineer", 27, listOf("I am Kotlin Learner", "At Kotlination"))
    test = person.toString()

    val jsonPerson: String = gson.toJson(test)

    println(jsonPerson)
}


fun fromJson() {
    val json = """{"name": "Kolineer", "age": "26", "messages" : ["Master Kotlin","At Kolination"]}"""
    val gson = Gson()

    val person1: Person = gson.fromJson(json, Person::class.java)
    println(person1)
}

fun testMap() {
    val json = """{"name": "Kolineer", "age": "26", "messages" : ["Master Kotlin","At Kolination"]}"""
    val gson = GsonBuilder().setPrettyPrinting().create()

    println("=== Map from JSON ===")
    var personMap: Map<String, Any> = gson.fromJson(json, object : TypeToken<Map<String, Any>>() {}.type)
    personMap.forEach { println(it) }

    println("=== Map to JSON ===")
    val jsonPersonMap: String = gson.toJson(personMap)
    println(jsonPersonMap)
}
