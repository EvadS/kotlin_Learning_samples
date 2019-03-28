package com.kotlination.jsonstring

open class Base(val name: String)

open class Person( name: String, val age: Int, val messages: List<String>) : Base(name)

class Employer(name: String,  age: Int,  messages: List<String>,var salary: Float):Person(name,age,messages)