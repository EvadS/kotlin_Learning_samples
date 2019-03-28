package com.javasampleapproach.kotlin.manytomany.controller

import com.javasampleapproach.kotlin.manytomany.model.Student
import com.javasampleapproach.kotlin.manytomany.model.Subject
import com.javasampleapproach.kotlin.manytomany.repo.StudentRepository
import com.javasampleapproach.kotlin.manytomany.repo.SubjectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.transaction.Transactional

@RestController
@RequestMapping("/api")
class RestAPIsController {
	@Autowired
	lateinit var studentRepository: StudentRepository
	
	@Autowired
	lateinit var subjectRepository: SubjectRepository

	@GetMapping("/clear")
	@Transactional
	fun clear(): String{
		// delete all data 
		subjectRepository.deleteAll()
		studentRepository.deleteAll()
		
		return "Done!"
	}

	@GetMapping("/save")
	fun save(): String {
		//prepare subjects 
		/*val math = Subject("1", "Mathematics")
		val computer = Subject("2", "Compter")
		val economics = Subject("3", "Economics")
		
		// attached subjects for each student
		val jack = Student("Jack", listOf(math, computer, economics))
		val peter = Student("Peter", listOf(computer, economics))
		
		// persist nodeInfoContainers to database
		studentRepository.save(listOf(jack, peter))
		*/
		return "Done!"
	}
	
	@GetMapping("/nodeInfoContainers")
	fun retrieveAllStudents(): String{
		// fetch all nodeInfoContainers from database
		val students = studentRepository.findAll()
		
		// some processing for better String format on browser showing 
		var info : String = ""
		students.forEach{
			info += it.toString() + "<br>"
		}
		
		return info
	}
	
	@GetMapping("/subjects")
	fun retrieveAllSubjects(): String{
		// fetch all nodeInfoContainers from database
		val subjects = subjectRepository.findAll()
		
		// some processing for better String format on browser showing 
		var info : String = ""
		subjects.forEach{
			info += it.toString() + "<br>"
		}
		
		return info
	}
}